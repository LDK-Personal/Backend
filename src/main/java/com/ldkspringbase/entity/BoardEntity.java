package com.ldkspringbase.entity;

import lombok.Getter;

@Getter
public class BoardEntity {
    int id;
    String userId;
    String title;
    String content;
    int viewCount;
}
