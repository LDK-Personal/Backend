package com.ldkspringbase.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardEntity {
    int id;
    String userName;
    String title;
    String content;
    String nowDay;
    int viewCount;
    int membersNumber;
    String memberId;
    String memberPassword;
}
