package com.jps.apitests.services;

import com.jps.apitests.domain.UUser;
import com.jps.apitests.exceptions.DataIntegratyViolationException;
import com.jps.apitests.exceptions.ObjectNotFoundException;
import com.jps.apitests.repositories.UserRepository;
import com.jps.apitests.web.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UUser findById(Integer id) {

        Optional<UUser> user = userRepository.findById(id);
        return  user.orElseThrow(() -> new ObjectNotFoundException("User not found"));

    }

    public List<UUser> findAll(){
        return userRepository.findAll();
    }

    @Override
    public UUser create(UserDTO userDTO) {

        findByEmail(userDTO);
        return userRepository.save(modelMapper.map(userDTO, UUser.class));
    }

    @Override
    public UUser update(UserDTO userDTO) {
        findByEmail(userDTO);
        return userRepository.save(modelMapper.map(userDTO, UUser.class));
    }

    private void findByEmail(UserDTO userDTO) {

        Optional<UUser> user = userRepository.findByEmail(userDTO.getEmail());

        if(user.isPresent() && !user.get().getId().equals(userDTO.getId())) {
            throw new DataIntegratyViolationException("Email already exists");
        }
    }
}
