package com.example.quiz.Controller;

import com.example.quiz.model.Questions;
import com.example.quiz.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("questions")

public class QuestionsController {
    @Autowired
    QuestionsService questionsService;

    @PostMapping("save-all")
    public void saveAll(@RequestBody List<Questions> list) {
        questionsService.addQuestions(list);
    }
}
