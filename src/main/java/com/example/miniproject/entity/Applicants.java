package com.example.miniproject.entity;

import com.example.miniproject.dto.ApplicantsRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Applicants extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicants_id")
    private Long id;

    @Column
    private Long boardId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private User user;

    public Applicants(ApplicantsRequestDto requestDto) {
        this.boardId = requestDto.getBoardId();
        this.user = requestDto.getUser();
    }
}
