package com.jps.apitests.services;

import com.jps.apitests.domain.UUser;
import com.jps.apitests.exceptions.ObjectNotFoundException;
import com.jps.apitests.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UUser findById(Integer id) {

        Optional<UUser> user = userRepository.findById(id);
        return  user.orElseThrow(() -> new ObjectNotFoundException("User not found"));

    }
}
