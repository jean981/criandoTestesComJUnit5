package com.jps.apitests.services;

import com.jps.apitests.domain.UUser;

public interface UserService {

    UUser findById(Integer id);
}
