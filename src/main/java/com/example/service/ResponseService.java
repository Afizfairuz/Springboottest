package com.example.service;

import com.example.model.Response;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResponseService {
    private final List<Response> responses = new ArrayList<>();

    // Menyimpan respons
    public Response submitResponse(Response response) {
        // Simpan respons tanpa ID
        responses.add(response);
        return response;
    }

    // Mendapatkan semua respons berdasarkan formId
    public List<Response> getAllResponses(Long formId) {
        List<Response> formResponses = new ArrayList<>();
        for (Response response : responses) {
            if (response.getFormId().equals(formId)) {
                formResponses.add(response);
            }
        }
        return formResponses;
    }

    // Mendapatkan respons pertama berdasarkan formId dan userId
    public Response getResponse(Long formId, Long userId) {
        for (Response response : responses) {
            if (response.getFormId().equals(formId) && response.getUserId().equals(userId)) {
                return response; // Kembalikan respons jika ditemukan
            }
        }
        return null; // Kembalikan null jika tidak ada respons yang cocok
    }

    // Menghapus respons berdasarkan formId dan userId
    public boolean deleteResponse(Long formId, Long userId) {
        return responses.removeIf(response -> response.getFormId().equals(formId) && response.getUserId().equals(userId));
    }
}