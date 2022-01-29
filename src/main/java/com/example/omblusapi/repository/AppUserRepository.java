package com.example.omblusapi.repository;

//we must extend our repository with JpaRepository, which itself extends PagingAndSortingRepository which extends CrudRepository
//we need to pass type and identifier datatype to JpaRepository. In our case, type is AppUser and ID datatype is Long (our AppUser id is Long)

import com.example.omblusapi.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    //special query, which returns AppUser object. For getting single user data
    @Query("SELECT s FROM AppUser s WHERE s.username = ?1")
     AppUser getUserByUsername(String username);

    //basically same query as before, but for checking user existence
    @Query("SELECT s FROM AppUser s WHERE s.username = ?1")
    Optional<AppUser> findUserByUsername(String username);
}
