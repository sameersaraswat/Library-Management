package com.example.library_management.repo;

import com.example.library_management.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findUserByUsername(String username);

}
