package com.example.miniproject.service;

import com.example.miniproject.dto.BoardRequestDto;
import com.example.miniproject.dto.BoardResponseDto;
import com.example.miniproject.entity.Board;
import com.example.miniproject.entity.User;
import com.example.miniproject.jwt.JwtUtil;
import com.example.miniproject.repository.BoardRepository;
import com.example.miniproject.repository.UserRepository;
import com.example.miniproject.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    //create
    @Transactional
    public BoardResponseDto createBoard(BoardRequestDto requestDto, UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        Board board = new Board(requestDto);
        board.setUser(user);
        boardRepository.save(board);
        return new BoardResponseDto(board);
    }


}
