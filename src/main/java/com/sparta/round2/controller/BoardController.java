package com.sparta.round2.controller;

import com.sparta.round2.dto.*;
import com.sparta.round2.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/boards")
    public ResponseEntity<BoardSaveResponseDto> saveBoard(@RequestBody BoardSaveRequestDto boardSaveRequestDto) {
        return ResponseEntity.ok(boardService.saveBoard(boardSaveRequestDto));
    }

    @GetMapping("/boards")
    public ResponseEntity<List<BoardSimpleResponseDto>> getBoards() {
        return ResponseEntity.ok(boardService.getBoards());
    }

    @GetMapping("/boards/{boardId}")
    public BoardDetailResponseDto getBoard(@PathVariable Long boardId) {
        return boardService.getBoard(boardId);
    }

    @PutMapping("/boards/{boardId}/title")
    public ResponseEntity<BoardUpdateTitleResponseDto> updateBoardTitle(
            @PathVariable Long boardId,
            @RequestBody BoardUpdateTitleRequestDto boardUpdateTitleRequestDto
    ) {
        return ResponseEntity.ok(boardService.updateBoardTitle(boardId, boardUpdateTitleRequestDto));
    }

    @PutMapping("/boards/{boardId}/contents")
    public ResponseEntity<BoardUpdateContentsResponseDto> updateBoardContents(
            @PathVariable Long boardId,
            @RequestBody BoardUpdateContentsRequestDto boardUpdateContentsRequestDto
    ) {
        return ResponseEntity.ok(boardService.updateBoardContents(boardId, boardUpdateContentsRequestDto));
    }

    @DeleteMapping("/boards/{boardId}")
    public void deleteBoard(@PathVariable Long boardId) { boardService.deleteBoard(boardId);}
}
