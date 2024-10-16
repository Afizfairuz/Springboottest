package com.example.controller;

import com.example.model.Form;
import com.example.service.FormService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/forms")
public class FormController {
    private final FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }

    @PostMapping
    public ResponseEntity<?> createForm(@RequestBody Form form) {
        Form createdForm = formService.createForm(form);
        return ResponseEntity.ok(Map.of("message", "Create form success", "form", createdForm));
    }

    @GetMapping
    public ResponseEntity<?> getAllForms() {
        List<Form> forms = formService.getAllForms();
        return ResponseEntity.ok(Map.of("message", "Get all forms success", "forms", forms));
    }

    @GetMapping("/{slug}")
    public ResponseEntity<?> getFormBySlug(@PathVariable String slug) {
        Optional<Form> form = formService.get        );
        return form.map(value -> ResponseEntity.ok(Map.of("message", "Get form success", "form", value)))
                   .orElseGet(() -> ResponseEntity.status(404).body(Map.of("message", "Form not found")));
    }
}