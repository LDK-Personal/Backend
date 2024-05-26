package com.ldkspringbase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldkspringbase.dto.BoardDto;
import com.ldkspringbase.entity.BoardEntity;
import com.ldkspringbase.mapper.BoardMapper;

@Service
public class BoardService {

	private final BoardMapper boardMapper;

	@Autowired
	public BoardService(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}

	public List<BoardEntity> getAllBoards() {
		return boardMapper.getAllBoards();
	}

	public BoardDto getBoardById(int id) {
		return boardMapper.getBoardById(id);
	}

	public boolean createBoard(BoardDto boardDto) {
		return boardMapper.createBoard(boardDto);
	}

	public boolean deleteBoard(int id) {
		return boardMapper.deleteBoard(id);
	}

	public boolean updateBoard(int id, BoardDto boardDto) {
		return boardMapper.updateBoard(id, boardDto);
	}

}
