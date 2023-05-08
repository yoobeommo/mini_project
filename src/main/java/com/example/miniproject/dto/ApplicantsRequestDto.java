package com.example.miniproject.dto;

import com.example.miniproject.entity.Board;
import com.example.miniproject.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ApplicantsRequestDto {


    @NotNull
    private Long boardId; // board 객체 대신 boardId 필드를 사용


    private User user;

}
