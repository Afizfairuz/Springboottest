package com.example.controller;

import com.example.model.Response;
import com.example.service.ResponseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/forms/{formSlug}/responses")
public class ResponseController {
    private final ResponseService responseService;

    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @PostMapping
    public ResponseEntity<?> submitResponse(@PathVariable String formSlug, @RequestBody Response response) {
        response.setFormId(formSlug); // Simulasi penyimpanan formId
        Response submittedResponse = responseService.submitResponse(response);
        return ResponseEntity.ok(Map.of("message", "Submit response success", "response", submittedResponse));
    }

    @GetMapping
    public ResponseEntity<?> getAllResponses(@PathVariable String formSlug) {
        List<Response> responses = responseService.getAllResponses(formSlug); // Ganti dengan formId yang sebenarnya
        return ResponseEntity.ok(Map.of("message", "Get responses success", "responses", responses));
    }
}