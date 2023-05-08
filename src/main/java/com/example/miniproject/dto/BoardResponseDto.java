package com.example.miniproject.dto;

import com.example.miniproject.entity.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardResponseDto implements GeneralResponseDto{
    private Long id;
    private String type;
    private String title;
    private String date;
    private int totalMember;
    private int memberNum;
    private String contents;
    private String nickname;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

//    private List<CommentResponseDto> commentList;  //코멘트와 합치고 주석해제

    public BoardResponseDto(Board board){
        this.id = board.getId();
        this.type =board.getType();
        this.title = board.getTitle();
        this.date= board.getDate();
        this.totalMember= board.getTotalMember();
        this.memberNum = board.getMemberNum();
        this.contents=board.getContents();
        this.nickname= board.getNickname();
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();

    }

}
