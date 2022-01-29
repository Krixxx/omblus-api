package com.example.omblusapi.service;

import com.example.omblusapi.repository.ActiveWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ActiveWorkerService {

    private final ActiveWorkerRepository activeWorkerRepository;

    @Autowired
    public ActiveWorkerService(ActiveWorkerRepository activeWorkerRepository) {
        this.activeWorkerRepository = activeWorkerRepository;
    }
}
