package com.example.quiz.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_questions_record")
public class UserQuestionsRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Column(name = "q_id")
    private int qId;

    public UserQuestionsRecord() {
    }

    public UserQuestionsRecord(String name, int qId) {
        this.name = name;
        this.qId = qId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getqId() {
        return qId;
    }
}
