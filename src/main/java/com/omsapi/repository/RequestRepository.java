package com.omsapi.repository;

import com.omsapi.models.Request;
import com.omsapi.models.enums.RequestState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    List<Request> findAllByOwnerId(Long id);

    @Query(value = "UPDATE Request SET state := WHERE id :=", nativeQuery = true)
    Request updateStatus(Long id, RequestState state);
}

