package com.example.miniproject.dto;

import lombok.Getter;

@Getter
public class BoardRequestDto {
    private Long id;
    private String type; // type이 버튼누르면 선택되는 형식인데, String?
    private String title;
    private String date;
    private int memberNum;
    private int totalMember;
    private String contents;
}
