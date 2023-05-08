package com.example.miniproject.controller;

import com.example.miniproject.dto.ApplicantsRequestDto;
import com.example.miniproject.dto.GeneralResponseDto;
import com.example.miniproject.dto.ResponseDto;
import com.example.miniproject.entity.Board;
import com.example.miniproject.security.UserDetailsImpl;
import com.example.miniproject.service.ApplicantsService;
import com.example.miniproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController // @Controller 어노테이션은 html을 반환하기 때문에 RestController를 사용함
@RequiredArgsConstructor
public class ApplicantsController {

    private final ApplicantsService applicantsService;
    private final BoardService boardService;

    @ResponseBody
    @PostMapping("/applicants")
    public GeneralResponseDto AddApplicants(@RequestBody ApplicantsRequestDto applicantsRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        try {

            Board board = boardService.findBoardById(applicantsRequestDto.getBoardId()); // getBoard() 대신 getBoardId()를 사용

            return applicantsService.addApplicants(board, userDetails.getUser());
        } catch (Exception e) {
            return new ResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST.value()); // 예외 발생시 에러 내용, Httpstatus(400)을 리턴값으로 전달한다.
        }
    }

    @ResponseBody
    @DeleteMapping("/applicants")
    public ResponseDto DeleteApplicants(@RequestBody ApplicantsRequestDto applicantsRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        try {
            return applicantsService.deleteApplicants(applicantsRequestDto, userDetails.getUser());
        } catch (Exception e) {
            return new ResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST.value()); // 예외 발생시 에러 내용, Httpstatus(400)을 리턴값으로 전달한다.
        }
    }
}
