package com.example.service;

import com.example.model.Response;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResponseService {
    private final List<Response> responses = new ArrayList<>();

    
    public Response submitResponse(Response response) {
        
        responses.add(response);
        return response;
    }

    
    public List<Response> getAllResponses(Long formId) {
        List<Response> formResponses = new ArrayList<>();
        for (Response response : responses) {
            if (response.getFormId().equals(formId)) {
                formResponses.add(response);
            }
        }
        return formResponses;
    }

    
    public Response getResponse(Long formId, Long userId) {
        for (Response response : responses) {
            if (response.getFormId().equals(formId) && response.getUserId().equals(userId)) {
                return response; 
            }
        }
        return null; 
    }

    
    public boolean deleteResponse(Long formId, Long userId) {
        return responses.removeIf(response -> response.getFormId().equals(formId) && response.getUserId().equals(userId));
    }
}