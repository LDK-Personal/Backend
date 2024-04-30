package com.ldkspringbase.service;

import com.ldkspringbase.entity.BoardEntity;
import com.ldkspringbase.mapper.BoardMapper;
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

    public BoardEntity createBoard(BoardEntity board) {
        try {
            boardMapper.createBoard(board);
            return board;
        } catch (Exception e) {
            // 실패 시 예외 처리
            throw new RuntimeException("보드 생성에 실패하였습니다.", e);
        }
    }
    public boolean updateBoard(int id, BoardEntity board) {
        try {
            BoardEntity existingBoard = boardMapper.getBoardById(id);
            if (existingBoard != null) {
                board.setId(id);
                boardMapper.updateBoard(board);
                return true;
            } else {
                // Board not found, update failed
                return false;
            }
        } catch (Exception e) {
            // 실패 시 예외 처리
            throw new RuntimeException("보드 업데이트에 실패하였습니다.", e);
        }
    }

    public boolean deleteBoard(int id) {
        try {
            BoardEntity existingBoard = boardMapper.getBoardById(id);
            if (existingBoard != null) {
                boardMapper.deleteBoard(id);
                return true;
            } else {
                // Board not found, delete failed
                return false;
            }
        } catch (Exception e) {
            // 실패 시 예외 처리
            throw new RuntimeException("보드 삭제에 실패하였습니다.", e);
        }
    }

    public void registerMember(BoardEntity member) {
        boardMapper.registerMember(member);
    }

    public BoardEntity getMemberByIdAndPassword(String id, String password) {
        return boardMapper.getMemberByIdAndPassword(id, password);
    }
}
