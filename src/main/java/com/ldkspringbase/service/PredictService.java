package com.ldkspringbase.service;

import com.ldkspringbase.ai.PredictionFace;
import com.ldkspringbase.entity.PredictionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class PredictService {
    private final PredictionFace predictionFace;

    public PredictionDTO executeEmotions(MultipartFile multipartFile) {
        return predictionFace.executeEmotions(multipartFile);
    }
}
