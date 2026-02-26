package com.example.quiz.repository;

import com.example.quiz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "select name from users where name = ?1", nativeQuery = true)
    String isAlreadyExist(String n);

}
