package com.example.service;

import com.example.model.Form;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FormService {
    private final List<Form> forms = new ArrayList<>();

    public Form createForm(Form form) {
        form.setId((long) (forms.size() + 1));
        forms.add(form);
        return form;
    }

    public List<Form> getAllForms() {
        return forms;
    }

    public Optional<Form> getFormBySlug(String slug) {
        return forms.stream().filter(f -> f.getSlug().equals(slug)).findFirst();
    }
}