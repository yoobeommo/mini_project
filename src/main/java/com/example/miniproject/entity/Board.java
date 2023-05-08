package com.example.miniproject.entity;

import com.example.miniproject.dto.BoardRequestDto;
import com.example.miniproject.dto.BoardResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class Board extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private  int totalMember;

    @Column(nullable = false)
    private int memberNum;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String nickname;

    @ManyToOne
    @JoinColumn
    private User user;


    public Board(BoardRequestDto requestDto) {
        this.type = requestDto.getType();
        this.title = requestDto.getTitle();
        this.date = requestDto.getDate();
        this.memberNum = requestDto.getMemberNum();
        this.totalMember = requestDto.getTotalMember();
        this.contents = requestDto.getContents();
        this.nickname = requestDto.getNickname();
    }

    public void update(BoardRequestDto requestDto){
        this.type = requestDto.getType();
        this.title = requestDto.getTitle();
        this.date = requestDto.getDate();
        this.memberNum = requestDto.getMemberNum();
        this.totalMember = requestDto.getTotalMember();
        this.contents = requestDto.getContents();
    }

}
