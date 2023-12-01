package com.ldkspringbase.service;

import com.ldkspringbase.entity.BoardEntity;
import com.ldkspringbase.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    public List<BoardEntity> getAllBoards() {
        return boardMapper.getAllBoards();
    }

    public BoardEntity getBoardById(int id) {
        return boardMapper.getBoardById(id);
    }

    public void createBoard(BoardEntity board) {
        boardMapper.createBoard(board);
    }

    public void updateBoard(BoardEntity board) {
        boardMapper.updateBoard(board);
    }

    public void deleteBoard(Long id) {
        boardMapper.deleteBoard(id);
    }
}
