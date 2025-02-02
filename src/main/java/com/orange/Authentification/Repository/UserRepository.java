package com.orange.Authentification.Repository;

import com.orange.Authentification.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User>findByEmail(String email);
}
