/**
 * 
 */
package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer>{
	Optional<AppUser> findByUsername(String username);
	List<AppUser> findByActive(boolean active);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
}
