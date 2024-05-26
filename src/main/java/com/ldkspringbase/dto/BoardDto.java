package com.ldkspringbase.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardDto {
	String userId;
	String title;
	String content;

	@Builder
	public BoardDto(String userId, String title, String content, int viewCount) {
		this.userId = userId;
		this.title = title;
		this.content = content;
	}
}
