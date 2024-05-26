package com.ldkspringbase.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ldkspringbase.ai.PredictionFace;
import com.ldkspringbase.entity.PredictionDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PredictService {
    private final PredictionFace predictionFace;

    public PredictionDTO executeEmotions(MultipartFile multipartFile) {
        return predictionFace.executeEmotions(multipartFile);
    }

}
