package com.ldkspringbase.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ldkspringbase.entity.PredictionDTO;
import com.ldkspringbase.service.PredictService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/predict")
@RequiredArgsConstructor
public class PredictController {

    private final PredictService predictService;

    @PostMapping
    public ResponseEntity<PredictionDTO> executeEmotions(@RequestBody MultipartFile multipartFile) {
        return ResponseEntity.ok(predictService.executeEmotions(multipartFile));
    }

}
