package com.jps.apitests.repositories;

import com.jps.apitests.domain.UUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UUser, Integer> {

    Optional<UUser> findByEmail(String email);
}
