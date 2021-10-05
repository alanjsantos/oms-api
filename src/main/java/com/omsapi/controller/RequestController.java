package com.omsapi.controller;

import com.omsapi.models.Request;
import com.omsapi.models.User;
import com.omsapi.service.RequestService;
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
@RequestMapping("requests")
public class RequestController {

    @Autowired
    private RequestService service;

    @PostMapping
    public ResponseEntity<Request> save(@RequestBody Request request) {
        request = service.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }

    @PutMapping("{id]")
    public ResponseEntity<Request> update(@RequestBody Request request, @PathVariable Long id) {
        request.setId(id);
        request = service.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }

    @GetMapping("{id}")
    public ResponseEntity<Request> findById(Long id) {
        Request request = service.findById(id);

        return ResponseEntity.ok(request);
    }

    @GetMapping
    public ResponseEntity<List<Request>> findAll() {
        List<Request> requests = service.findAll();

        return ResponseEntity.ok(requests);
    }

}
