package com.tpsbackendsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tpsbackendsystem.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
