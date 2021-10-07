package com.omsapi.controller;

import com.omsapi.models.RequestStage;
import com.omsapi.service.RequestStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("request-stages")
@RestController
public class RequestStageController {

    @Autowired
    private RequestStageService service;


    @PostMapping
    public ResponseEntity<RequestStage> save(@RequestBody RequestStage requestStage) {
        requestStage = service.save(requestStage);

        return ResponseEntity.status(HttpStatus.CREATED).body(requestStage);
    }

    @GetMapping("{id}")
    public ResponseEntity<RequestStage> findById(@PathVariable Long id) {
        RequestStage requestStage = service.findById(id);
        return ResponseEntity.ok(requestStage);
    }


}
