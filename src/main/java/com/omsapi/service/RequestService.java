package com.omsapi.service;

import com.omsapi.models.Request;
import com.omsapi.models.enums.RequestState;
import com.omsapi.repository.RequestRepository;
import com.omsapi.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    private RequestRepository repository;

    public Request save(Request request) {
        request.setState(RequestState.OPEN);
        request.setCreationDate(new Date());
        return repository.save(request);
    }

    public Request update(Request request) {
        return repository.save(request);
    }

    public Request findById(Long id) {
        Optional<Request> result = repository.findById(id);

        return result.get();
    }

    public List<Request> findAll() {
        return repository.findAll();
    }

    public List<Request> listAllByOwnerId(Long id) {
        return repository.findAllByOwnerId(id);
    }
}
