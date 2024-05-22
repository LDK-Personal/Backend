package com.ldkspringbase.controller;

import com.ldkspringbase.entity.PredictionDTO;
import com.ldkspringbase.service.PredictService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/predict")
@RequiredArgsConstructor
public class PredictController {
    private final PredictService predictService;
    @PostMapping
    public PredictionDTO executeEmotions(@RequestBody MultipartFile multipartFile) {
        return predictService.executeEmotions(multipartFile);
    }
}
