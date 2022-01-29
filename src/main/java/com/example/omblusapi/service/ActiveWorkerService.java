package com.example.omblusapi.service;

import com.example.omblusapi.model.ActiveWorker;
import com.example.omblusapi.repository.ActiveWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActiveWorkerService {

    private final ActiveWorkerRepository activeWorkerRepository;

    @Autowired
    public ActiveWorkerService(ActiveWorkerRepository activeWorkerRepository) {
        this.activeWorkerRepository = activeWorkerRepository;
    }

    public List<ActiveWorker> getAllActiveWorkers(){
        return activeWorkerRepository.findAll();
    }
}
