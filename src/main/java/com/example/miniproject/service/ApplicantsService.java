package com.example.miniproject.service;

import com.example.miniproject.dto.ApplicantsRequestDto;
import com.example.miniproject.dto.GeneralResponseDto;
import com.example.miniproject.dto.ResponseDto;
import com.example.miniproject.dto.StatusResponseDto;
import com.example.miniproject.entity.Applicants;
import com.example.miniproject.entity.Board;
import com.example.miniproject.entity.User;
import com.example.miniproject.repository.ApplicantsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ApplicantsService {

    private final ApplicantsRepository applicantsRepository;

    @Transactional
    public GeneralResponseDto addApplicants(Board board, User user) {
        try {
            Applicants applicants = new Applicants(board, user);
            applicantsRepository.save(applicants);
            return new StatusResponseDto("신청이 완료되었습니다.", HttpStatus.OK);
        } catch (Exception e) {
            return new StatusResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
//        if(user == null){
//            throw new IllegalArgumentException("로그인이 필요합니다");
//        }
//        applicantsRequestDto.setUser(user);
//        Applicants applicants = new Applicants(applicantsRequestDto);
//        applicantsRepository.save(applicants);
//        return new ResponseDto("신청 완료!", HttpStatus.OK.value()); // DB에 정상적으로 저장 되었을 경우 결과 리턴
    }

    @Transactional
    public ResponseDto deleteApplicants(ApplicantsRequestDto applicantsRequestDto, User user) {
        if(user == null){
            throw new IllegalArgumentException("로그인이 필요합니다");
        }
        applicantsRepository.deleteById(applicantsRequestDto.getUser().getId());
        return new ResponseDto("신청 취소 완료!", HttpStatus.OK.value()); // DB에 정상적으로 저장 되었을 경우 결과 리턴
    }


}
