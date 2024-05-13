package com.ldkspringbase.controller;

import com.ldkspringbase.service.EmotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/emotion")
@RequiredArgsConstructor
public class EmotionController {
    private final EmotionService emotionService;
    @PostMapping
    public MultipartFile executeEmotions(@RequestBody MultipartFile multipartFile) {
        return emotionService.executeEmotions(multipartFile);
    }
}
