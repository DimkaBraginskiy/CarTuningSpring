package com.api.carTuning.repository;

import com.api.carTuning.model.Tuning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuningRepository extends JpaRepository<Tuning, Long> {
}
