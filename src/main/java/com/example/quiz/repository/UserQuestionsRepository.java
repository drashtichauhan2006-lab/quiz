package com.example.quiz.repository;
import com.example.quiz.model.UserQuestionsRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserQuestionsRepository extends JpaRepository<UserQuestionsRecord, Integer> {
    @Query(value = "select name from user_questions_record where name = ?1 and q_id = ?2", nativeQuery = true)
    String checkQuestionAlreadyExistingForUser(String name, int id);
}
