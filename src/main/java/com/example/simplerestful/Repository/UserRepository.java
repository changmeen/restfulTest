package com.example.simplerestful.Repository;


import com.example.simplerestful.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
