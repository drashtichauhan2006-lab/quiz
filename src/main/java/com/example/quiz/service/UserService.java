package com.example.quiz.service;

import com.example.quiz.DTO.GetResultResponse;
import com.example.quiz.DTO.UserRegisterResponse;
import com.example.quiz.model.User;
import com.example.quiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    // runs query to check if the name user has passed for register himself/herself is already existing or not
    public UserRegisterResponse registerUser(User user) {
        String res = userRepository.isAlreadyExist(user.getName());

        if (res == null) {
            userRepository.save(user);
            return new UserRegisterResponse(HttpStatus.OK, user.getName() + " registered successfully");
        } else {
            return new UserRegisterResponse(HttpStatus.OK, "User already exists, register with other name");
        }
    }

    public boolean isValidUser(String name) {
        return userRepository.existsById(name);
    }

    public void updateAttemptedAndResult(String userName) {
        User user = userRepository.findById(userName).orElseThrow();

        user.setAttempted(user.getAttempted() + 1);
        user.setResult(user.getResult() + 1);

        userRepository.save(user);
    }

    public void updateAttempted(String userName) {
        User user = userRepository.findById(userName).orElseThrow();

        user.setAttempted(user.getAttempted() + 1);

        userRepository.save(user);
    }

    public GetResultResponse getResult(String userName) {
        User user = userRepository.findById(userName).orElseThrow();

        if (user.getAttempted() < 5) {
            return new GetResultResponse(HttpStatus.OK, "Finish your quiz first");
        }
        return new GetResultResponse(HttpStatus.OK, "Result: " + user.getResult());
    }

    public int getAttempted(String userName) {
        return userRepository.findById(userName).orElseThrow().getAttempted();
    }
}
