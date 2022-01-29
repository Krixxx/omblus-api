package com.example.omblusapi.repository;

//we must extend our repository with JpaRepository, which itself extends PagingAndSortingRepository which extends CrudRepository
//we need to pass type and identifier datatype to JpaRepository. In our case, type is AppUser and ID datatype is Long (our AppUser id is Long)

import com.example.omblusapi.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
