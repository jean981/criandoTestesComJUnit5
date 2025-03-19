package com.jps.apitests.services;

import com.jps.apitests.domain.UUser;
import com.jps.apitests.web.dto.UserDTO;

import java.util.List;

public interface UserService {

    UUser findById(Integer id);

    List<UUser> findAll();

    UUser create(UserDTO userDTO);

    UUser update(UserDTO userDTO);

    void delete(Integer id);

}
