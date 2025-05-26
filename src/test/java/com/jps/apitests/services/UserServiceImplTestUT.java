package com.jps.apitests.services;

import com.jps.apitests.domain.UUser;
import com.jps.apitests.exceptions.DataIntegratyViolationException;
import com.jps.apitests.exceptions.ObjectNotFoundException;
import com.jps.apitests.repositories.UserRepository;
import com.jps.apitests.web.dto.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImpUT {

    public static final Integer ID = 1;
    public static final String NAME = "Joao da Silva";
    public static final String EMAIL = "joao@gmail.com";
    public static final String PASSWORD = "senha123";
    public static final String USER_NOT_FOUND = "User not found";
    public static final int INDEX = 0;

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper mapper;

    private UUser user;

    private UserDTO userDTO;

    private Optional<UUser> optionalUser;

    @BeforeEach
    void setUp() {
        startUsers();
    }

    @Test
    void whenfindByIdThenReturnAnyUserInstance() {

        when(userRepository.findById(anyInt())).thenReturn(optionalUser);

        UUser response = userService.findById(ID);

        assertNotNull(response);
        assertEquals(UUser.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
    }

    @Test
    void whenfindByIdThenReturnObjectNotFoundException() {

        when(userRepository.findById(anyInt())).thenThrow(new ObjectNotFoundException(USER_NOT_FOUND));

        try {
            userService.findById(ID);
        }catch (Exception e){
            assertEquals(ObjectNotFoundException.class, e.getClass());
            assertEquals(USER_NOT_FOUND, e.getMessage());
        }
    }

    @Test
    void whenFindAllThenReturnUserList() {

        when(userRepository.findAll()).thenReturn(List.of(user));

        List<UUser> response = userService.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(UUser.class, response.get(INDEX).getClass());
        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(NAME, response.get(INDEX).getName());
        assertEquals(EMAIL, response.get(INDEX).getEmail());
    }

    @Test
    void whenCreateUserThenSuccess() {

        when(userRepository.save(any())).thenReturn(user);
        UUser response = userService.create(userDTO);

        assertNotNull(response);
        assertEquals(UUser.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());

    }

    @Test
    void whenCreateUserThenReturnUserAlreadyExistException() {

        when(userRepository.findByEmail(anyString())).thenReturn(optionalUser);

        try {
            optionalUser.get().setId(2);
            userService.create(userDTO);

        }catch (Exception ex){
            assertEquals(DataIntegratyViolationException.class, ex.getClass());
            assertEquals("Email already exists", ex.getMessage());
        }
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUsers(){
        user = new UUser(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
        optionalUser = Optional.of(new UUser(ID, NAME, EMAIL, PASSWORD));
    }
}