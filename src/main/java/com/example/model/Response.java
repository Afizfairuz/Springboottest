package com.example.model;

import java.util.Map;

public class Response {
    private Long id;
    private Long formId;
    private Long userId;
    private Map<String, String> answers; // Key: question name, Value: answer value
    private String submissionDate;

    // Constructors, Getters, and Setters
}