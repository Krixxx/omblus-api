package com.example.omblusapi.service;

import com.example.omblusapi.model.AppUser;
import com.example.omblusapi.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    //@Autowired is used for dependency injection

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }


    public List<AppUser> getAllAppUsers(){
        return appUserRepository.findAll();
    }

    public AppUser getUserByUserId(String userId){
         return appUserRepository.getUserByUserId(userId);
    }

    public AppUser createNewAppUser(AppUser appUser){

        Optional<AppUser> appUserOptional = appUserRepository.findUserByUserId(appUser.getUserId());

        if(appUserOptional.isPresent()){
            throw new IllegalStateException("user with same user ID is already created");
        }

        return appUserRepository.save(appUser);
    }

    public void deleteAppUserById(Long userId){

        boolean exists = appUserRepository.existsById(userId);

        if(!exists){
            throw new IllegalStateException("user with ID " + userId + " does not exist");
        }

        appUserRepository.deleteById(userId);
    }
}
