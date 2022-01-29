package com.example.omblusapi.repository;

import com.example.omblusapi.model.ActiveWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiveWorkerRepository extends JpaRepository<ActiveWorker, Long> {

    //delete user line by userId
    @Modifying
    @Query("DELETE FROM ActiveWorker s WHERE s.userId = :user")
    void deleteByUserId(@Param("user")String userId);
}
