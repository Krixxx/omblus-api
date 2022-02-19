package com.example.omblusapi.controller;

import com.example.omblusapi.model.AppUser;
import com.example.omblusapi.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class AppUserController {

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping
    public ResponseEntity<List<AppUser>> getAllUsers(){
        return ResponseEntity.ok().body(appUserService.getAllAppUsers());
    }

    //this path takes in username, NOT AppUser id.
    @GetMapping(path="{username}")
    public ResponseEntity<AppUser> getUserByUserId(@PathVariable String username){

        if(appUserService.getUserByUsername(username) == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(appUserService.getUserByUsername(username));
    }

    @PostMapping
    public ResponseEntity<AppUser> createNewAppUser(@RequestBody AppUser appUser){

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/v1/users").toUriString());

        return ResponseEntity.created(uri).body(appUserService.createNewAppUser(appUser));
    }

    @DeleteMapping(path="{userId}")
    public ResponseEntity<Object> deleteAppUser(@PathVariable Long userId){

        appUserService.deleteAppUserById(userId);

        return new ResponseEntity<>("user deleted",HttpStatus.OK);
    }

}
