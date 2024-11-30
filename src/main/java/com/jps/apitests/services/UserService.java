package com.jps.apitests.services;

import com.jps.apitests.domain.UUser;

import java.util.List;

public interface UserService {

    UUser findById(Integer id);

    List<UUser> findAll();
}
