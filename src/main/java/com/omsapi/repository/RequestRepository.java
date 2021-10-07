package com.omsapi.repository;

import com.omsapi.models.Request;
import com.omsapi.models.enums.RequestState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    List<Request> findAllByOwnerId(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE request SET state = ?1 WHERE id = ?2")
    Integer updateStatus(RequestState state, Long id);
}

