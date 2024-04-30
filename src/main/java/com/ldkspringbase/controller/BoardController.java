package com.ldkspringbase.controller;

import com.ldkspringbase.entity.BoardEntity;
// import com.ldkspringbase.mapper.BoardMapper;
import com.ldkspringbase.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    // 전체 목록 조회
    @GetMapping("/all")
    public List<BoardEntity> getAllBoards() {
        return boardService.getAllBoards();
    }

    // 글 하나 조회
    @GetMapping("/{id}")
    public BoardEntity getBoardById(@PathVariable int id) {
        return boardService.getBoardById(id);
    }

    // 글 등록
    @PostMapping
    public BoardEntity createBoard(@RequestBody BoardEntity board) {
        return boardService.createBoard(board);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBoard(@PathVariable int id, @RequestBody BoardEntity board) {
        boolean isUpdated = boardService.updateBoard(id, board);

        if (isUpdated) {
            return ResponseEntity.ok("Board updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Board not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable int id) {
        boolean isDeleted = boardService.deleteBoard(id);

        if (isDeleted) {
            return ResponseEntity.ok("Board deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Board not found with id: " + id);
        }
    }

    @PostMapping("/register")
    public String registerMember(@RequestBody BoardEntity member) {
        boardService.registerMember(member);
        return "Member registered successfully.";
    }

    @PostMapping("/login")
    public String loginMember(@RequestBody BoardEntity member) {
        BoardEntity foundMember = boardService.getMemberByIdAndPassword(member.getMemberId(), member.getMemberPassword());
        if (foundMember != null) {
            return "Login successful.";
        } else {
            return "Invalid credentials. Please try again.";
        }
    }

}
