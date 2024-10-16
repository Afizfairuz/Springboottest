package com.example.model;

public class Question {
    private Long id;
    private Long formId;
    private String name;
    private String choiceType;
    private String choices; // Comma-separated choices for multiple choice, dropdown, checkboxes
    private boolean isRequired;

    // Constructors, Getters, and Setters
}