package com.omsapi.repository;

import com.omsapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user WHERE email = :email AND password = :password", nativeQuery = true)
    Optional<User> login(@Param("email") String email, @Param("password") String password);
}
