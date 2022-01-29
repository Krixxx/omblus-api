package com.example.omblusapi.repository;

import com.example.omblusapi.model.ActiveWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiveWorkerRepository extends JpaRepository<ActiveWorker, Long> {
}
