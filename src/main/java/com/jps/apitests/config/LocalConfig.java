package com.jps.apitests.config;

import com.jps.apitests.domain.UUser;
import com.jps.apitests.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository userRepository;
    @PostConstruct
    public void startDb(){

        UUser u1 = new UUser(null,"bob fisher","bob@gmail.com","pass123");
        UUser u2 = new UUser(null,"maria louca","louca@gmail.com","pass123");

        userRepository.saveAll(List.of( u1,u2));

    }
}
