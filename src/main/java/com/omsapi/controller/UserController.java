package com.omsapi.controller;

import com.omsapi.models.Request;
import com.omsapi.models.User;
import com.omsapi.models.dto.UserLoginDTO;
import com.omsapi.repository.RequestRepository;
import com.omsapi.service.RequestService;
import com.omsapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService service;

    private RequestService requestService;
    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        user = service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id){
        user.setId(id);
        user = service.update(user);

        return ResponseEntity.ok(user);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(Long id) {
        User user = service.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> findALl() {
        List<User> users = service.findAll();

        return ResponseEntity.ok(users);
    }

    @PostMapping("login")
    public ResponseEntity<User> login(UserLoginDTO loginDTO) {
        User user = service.login(loginDTO.getEmail(), loginDTO.getPassword());

        return ResponseEntity.ok(user);
    }

    @GetMapping("{id}/requests")
    public ResponseEntity<List<Request>> listAllRequestsById(@PathVariable Long id) {
        List<Request> requests = requestService.listAllByOwnerId(id);

        return ResponseEntity.ok(requests);
    }
}
