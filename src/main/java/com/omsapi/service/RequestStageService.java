package com.omsapi.service;

import com.omsapi.models.RequestStage;
import com.omsapi.repository.RequestRepository;
import com.omsapi.repository.RequestStageRepository;
import com.omsapi.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RequestStageService {

    @Autowired
    private RequestStageRepository repository;

    @Autowired
    private RequestRepository requestRepository;

    public RequestStage save(RequestStage requestStage) {
        requestStage.setRealizationDate(new Date());
        RequestStage createdStage = repository.save(requestStage);
        requestRepository.updateStatus(requestStage.getId(), requestStage.getState());

        return createdStage;
    }

    public RequestStage findById (Long id) {
        Optional<RequestStage> result = repository.findById(id);

        return result.orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    public List<RequestStage> listALlByRequestId(Long id) {
        return repository.findAllByRequestId(id);
    }
}
