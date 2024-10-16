package com.example.service;

import com.example.model.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private final List<Question> questions = new ArrayList<>();

    public Question addQuestion(Question question) {
        question.setId((long) (questions.size() + 1));
        questions.add(question);
        return question;
    }

    public Optional<Question> getQuestionById(Long id) {
        return questions.stream().filter(q -> q.getId().equals(id)).findFirst();
    }

    public boolean removeQuestion(Long id) {
        return questions.removeIf(q -> q.getId().equals(id));
    }
}