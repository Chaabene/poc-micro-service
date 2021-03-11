package com.elis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elis.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
