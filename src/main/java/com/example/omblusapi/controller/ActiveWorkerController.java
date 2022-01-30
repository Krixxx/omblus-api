package com.example.omblusapi.controller;

import com.example.omblusapi.model.ActiveWorker;
import com.example.omblusapi.service.ActiveWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/workers")
public class ActiveWorkerController {

    private final ActiveWorkerService activeWorkerService;

    @Autowired
    public ActiveWorkerController(ActiveWorkerService activeWorkerService) {
        this.activeWorkerService = activeWorkerService;
    }

    @GetMapping
    public ResponseEntity<List<ActiveWorker>> getAllActiveWorkers(){
        return ResponseEntity.ok().body(activeWorkerService.getAllActiveWorkers());
    }

    @GetMapping(path="{username}")
    public ResponseEntity<ActiveWorker> getWorkerByUsername(@PathVariable String username){
        return ResponseEntity.ok().body(activeWorkerService.getWorkerByUsername(username));
    }

    @PutMapping(path="{username}")
    public ResponseEntity<Object> updateWorker(@PathVariable String username, @RequestBody ActiveWorker updatedWorker){
        return ResponseEntity.ok().body(activeWorkerService.updateWorkerStatus(username, updatedWorker));
    }

}
