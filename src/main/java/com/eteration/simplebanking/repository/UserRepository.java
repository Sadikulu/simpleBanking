package com.eteration.simplebanking.repository;

import com.eteration.simplebanking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    Boolean existsByEmail(String email);

}
