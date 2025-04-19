package com.jps.apitests.services;

import com.jps.apitests.domain.UUser;
import com.jps.apitests.repositories.UserRepository;
import com.jps.apitests.web.dto.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@SpringBootTest
class UserServiceImpUT {

    public static final int ID = 1;
    public static final String NAME = "Joao da Silva";
    public static final String EMAIL = "joao@gmail.com";
    public static final String PASSWORD = "senha123";

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
        openMocks(this);
        startUsers();
    }

    @Test
    void whenfindByIdThenReturnAnyUserInstance() {

        when(userRepository.findById(Mockito.anyInt())).thenReturn(optionalUser);

        UUser response = userService.findById(ID);

        assertNotNull(response);
        assertEquals(UUser.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
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
        optionalUser = optionalUser.of(new UUser(ID, NAME, EMAIL, PASSWORD));
    }
}