package com.example.quiz.Controller;

import com.example.quiz.DTO.GetQuestionResponse;
import com.example.quiz.DTO.SubmitAnswerRequest;
import com.example.quiz.model.Questions;
import com.example.quiz.service.QuestionsService;
import com.example.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    UserService userService;

    @Autowired
    QuestionsService questionsService;

    // Get question only if user is registered
    @GetMapping("get-question/{userName}")
    public GetQuestionResponse getQuestion(@PathVariable String userName) {

        Questions question = null;

        // Check valid user
        if (!userService.isValidUser(userName)) {
            return new GetQuestionResponse(
                    question,
                    HttpStatus.OK,
                    "Invalid username or user not registered"
            );
        }

        // Check attempts limit
        if (userService.getAttempted(userName) >= 5) {
            return new GetQuestionResponse(
                    question,
                    HttpStatus.OK,
                    "You have attempted all questions. Check result."
            );
        }

        // Fetch question
        question = questionsService.getQuestion(userName);

        return new GetQuestionResponse(
                question,
                HttpStatus.OK,
                "Question fetched successfully"
        );
    }

    // Submit answer
    @PutMapping("submit-answer")
    public String submitAnswer(@RequestBody SubmitAnswerRequest answerRequest) {
        questionsService.checkAnswer(answerRequest);
        return "Answer submitted successfully";
    }
}
