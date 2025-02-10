package com.api.carTuning.repository;

import com.api.carTuning.model.Tuning;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuningRepository extends JpaRepository<Tuning, Long> {
}
