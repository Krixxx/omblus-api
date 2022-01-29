package com.example.omblusapi.repository;

import com.example.omblusapi.model.ActiveWorker;
import com.example.omblusapi.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiveWorkerRepository extends JpaRepository<ActiveWorker, Long> {

    //special query, which returns ActiveWorker object. For getting single worker data
    @Query("SELECT s FROM ActiveWorker s WHERE s.username = ?1")
    ActiveWorker getUserByUsername(String username);
}
