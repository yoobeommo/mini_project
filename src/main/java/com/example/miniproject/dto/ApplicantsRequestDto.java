package com.example.miniproject.dto;

import com.example.miniproject.entity.Board;
import com.example.miniproject.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicantsRequestDto {
    private Long boardId;
    private User user;

}
