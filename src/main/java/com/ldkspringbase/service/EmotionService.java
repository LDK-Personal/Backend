package com.ldkspringbase.service;

import com.ldkspringbase.ai.Emotion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class EmotionService {
    private final Emotion emotion;

    public MultipartFile executeEmotions(MultipartFile multipartFile) {
        return emotion.executeEmotions(multipartFile);
    }
}
