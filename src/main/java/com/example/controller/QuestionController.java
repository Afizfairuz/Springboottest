package com.example.controller;

import com.example.model.Question;
import com.example.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/forms/{formSlug}/questions")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<?> addQuestion(@PathVariable String formSlug, @RequestBody Question question) {
        question.setFormId(formSlug); 
        Question addedQuestion = questionService.addQuestion(question);
        return ResponseEntity.ok(Map.of("message", "Add question success", "question", addedQuestion));
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity<?> removeQuestion(@PathVariable String formSlug, @PathVariable Long questionId) {
        if (questionService.removeQuestion(questionId)) {
            return ResponseEntity.ok(Map.of("message", "Remove question success"));
        } else {
            return ResponseEntity.status(404).body(Map.of("message", "Question not found"));
        }
    }
}