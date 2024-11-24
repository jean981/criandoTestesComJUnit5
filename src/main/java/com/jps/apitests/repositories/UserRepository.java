package com.jps.apitests.repositories;

import com.jps.apitests.domain.UUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UUser, Integer> {

}
