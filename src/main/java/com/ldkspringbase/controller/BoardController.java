package com.ldkspringbase.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldkspringbase.dto.BoardDto;
import com.ldkspringbase.entity.BoardEntity;
import com.ldkspringbase.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;

	@GetMapping("/all")
	public ResponseEntity<List<BoardEntity>> getAllBoards() {
		return ResponseEntity.ok(boardService.getAllBoards());
	}

	@GetMapping("/{id}")
	public ResponseEntity<BoardDto> getBoardById(@PathVariable int id) {
		return ResponseEntity.ok(boardService.getBoardById(id));
	}

	@PostMapping("")
	public ResponseEntity<Boolean> createBoard(@RequestBody BoardDto boardDto) {
		return ResponseEntity.ok(boardService.createBoard(boardDto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Boolean> updateBoard(@PathVariable int id, @RequestBody BoardDto boardDto) {
		return ResponseEntity.ok(boardService.updateBoard(id, boardDto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteBoard(@PathVariable int id) {
		return ResponseEntity.ok(boardService.deleteBoard(id));
	}
}
