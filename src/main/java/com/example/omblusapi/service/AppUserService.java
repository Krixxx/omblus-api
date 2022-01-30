package com.example.omblusapi.service;

import com.example.omblusapi.model.ActiveWorker;
import com.example.omblusapi.model.AppUser;
import com.example.omblusapi.repository.ActiveWorkerRepository;
import com.example.omblusapi.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;
    private final ActiveWorkerRepository activeWorkerRepository;

    //@Autowired is used for dependency injection
    @Autowired
    public AppUserService(AppUserRepository appUserRepository, ActiveWorkerRepository activeWorkerRepository) {
        this.appUserRepository = appUserRepository;
        this.activeWorkerRepository = activeWorkerRepository;
    }

    public List<AppUser> getAllAppUsers(){
        return appUserRepository.findAll();
    }

    public AppUser getUserByUsername(String username){
         return appUserRepository.getUserByUsername(username);
    }

    public AppUser createNewAppUser(AppUser appUser){

        Optional<AppUser> appUserOptional = appUserRepository.findUserByUsername(appUser.getUsername());

        if(appUserOptional.isPresent()){
            throw new IllegalStateException("user with same user ID is already created");
        }

        //Save new activeWorker line, is new worker role is "worker"
        if(appUser.getRole().contains("worker")){
            activeWorkerRepository.save(new ActiveWorker(appUser.getUsername()));
        }

        return appUserRepository.save(appUser);
    }

    public void deleteAppUserById(Long userId){

        boolean exists = appUserRepository.existsById(userId);

        if(!exists){
            throw new IllegalStateException("user with ID " + userId + " does not exist");
        }

        //get AppUser data for given ID
        AppUser appUser = appUserRepository.getById(userId);


        //delete activeWorker line, if user role is "worker"
        if(appUser.getRole().contains("worker")){

            //"Active_Worker" table line id for user which we want to delete from database
            Long activeUserId = activeWorkerRepository.getActiveWorkerByUsername(appUser.getUsername()).getId();

            activeWorkerRepository.deleteById(activeUserId);

        }

        appUserRepository.deleteById(userId);
    }
}
