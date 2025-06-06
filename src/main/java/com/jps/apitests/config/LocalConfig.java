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
        UUser u2 = new UUser(null,"maria louca","louca@gmail.com","pass345");
        UUser u3 = new UUser(null,"mario bros","mario@gmail.com","pass567");
        UUser u4 = new UUser(null,"paul caugton","paulcaugton@gmail.com","pass789");
        UUser u5 = new UUser(null,"sergi silva","sergiosilva@gmail.com","pass098");

        userRepository.saveAll(List.of( u1,u2,u3,u4,u5));

    }
}
