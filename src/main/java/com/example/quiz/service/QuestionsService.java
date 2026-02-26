package com.example.quiz.service;

import com.example.quiz.DTO.SubmitAnswerRequest;
import com.example.quiz.model.Questions;
import com.example.quiz.model.UserQuestionsRecord;
import com.example.quiz.repository.QuestionRepository;
import com.example.quiz.repository.UserQuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    UserService userService;

    @Autowired
    UserQuestionsRepository userQuestionsRepository;

    public void addQuestions(List<Questions> list) {
        questionRepository.saveAll(list);
    }

    public Questions getQuestion(String userName) {
        return questionRepository.findAll().get(0);
    }

    public void checkAnswer(SubmitAnswerRequest req) {
        Questions q = questionRepository.findById(req.getqId()).orElseThrow();

        if (q.getAnswer() == req.getAnswer()) {
            userService.updateAttemptedAndResult(req.getUserName());
        } else {
            userService.updateAttempted(req.getUserName());
        }

        userQuestionsRepository.save(
                new UserQuestionsRecord(req.getUserName(), req.getqId()));
    }
}
