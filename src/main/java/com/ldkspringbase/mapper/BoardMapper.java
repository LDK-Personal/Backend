package com.ldkspringbase.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ldkspringbase.dto.BoardDto;
import com.ldkspringbase.entity.BoardEntity;

@Mapper
public interface BoardMapper {
	List<BoardEntity> getAllBoards();
	BoardDto getBoardById(int id);
	boolean createBoard(BoardDto boardDto);
	boolean updateBoard(@Param("id") int id, @Param("boardDto")BoardDto boardDto);
	boolean deleteBoard(int id);
}
