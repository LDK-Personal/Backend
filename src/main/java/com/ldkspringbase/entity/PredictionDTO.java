package com.ldkspringbase.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PredictionDTO {
    @JsonProperty("file_path")
    String filePath;
    Emotion emotion;
    String probability;

    @Builder
    public PredictionDTO(String filePath, Emotion emotion, String probability) {
        this.filePath = filePath;
        this.emotion = emotion;
        this.probability = probability;
    }
}
