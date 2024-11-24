package com.jps.apitests.controllers;


import com.jps.apitests.domain.UUser;
import com.jps.apitests.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UUser> findById(@PathVariable Integer id) {

        return
              ResponseEntity.ok().body(userService.findById(id));

    }


}
