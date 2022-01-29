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

    //delete user line by userId
    @Modifying
    @Query("DELETE FROM ActiveWorker s WHERE s.userId = ?1")
    void deleteByUserId(String userId);

    //special query, which returns ActiveWorker object. For getting single worker data
    @Query("SELECT s FROM ActiveWorker s WHERE s.userId = ?1")
    ActiveWorker getUserByUserId(String userId);
}
