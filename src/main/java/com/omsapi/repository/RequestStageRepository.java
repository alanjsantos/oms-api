package com.omsapi.repository;

import com.omsapi.models.RequestStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestStageRepository extends JpaRepository<RequestStage, Long> {
}
