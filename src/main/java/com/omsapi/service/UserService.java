package com.omsapi.service;

import com.omsapi.models.User;
import com.omsapi.repository.UserRepository;
import com.omsapi.utils.HasUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User save(User user) {
        String hash = HasUtil.getSecureHash(user.getPassword());
        user.setPassword(hash);
        return repository.save(user);
    }

    public User update(User user) {
        String hash = HasUtil.getSecureHash(user.getPassword());
        user.setPassword(hash);
        return repository.save(user);
    }

    public User findById(Long id) {
        Optional<User> result = repository.findById(id);

        return result.get();
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User login(String email, String password) {
        password = HasUtil.getSecureHash(password);
        Optional<User> result = repository.login(email, password);
        return result.get();
    }
}
