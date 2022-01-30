package com.example.omblusapi.service;

import com.example.omblusapi.model.ActiveWorker;
import com.example.omblusapi.repository.ActiveWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public ActiveWorker getWorkerByUsername(String username){
        return activeWorkerRepository.getActiveWorkerByUsername(username);
    }

    @Transactional
    public ActiveWorker updateWorkerStatus(String username,ActiveWorker activeWorker){

        ActiveWorker currentWorker = activeWorkerRepository.getActiveWorkerByUsername(username);

        currentWorker.setAlert(activeWorker.getAlert());
        currentWorker.setWorking(activeWorker.getWorking());
        currentWorker.setLoggedIn(activeWorker.getLoggedIn());

        return currentWorker;
    }
}
