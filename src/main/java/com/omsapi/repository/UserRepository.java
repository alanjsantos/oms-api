package com.omsapi.repository;

import com.omsapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT FROM USer WHERE email = ?1 AND password = ?2")
    Optional<User> login(String email, String password);
}
