package com.example.Challenge_4.repository;

import com.example.Challenge_4.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, String> {
}
