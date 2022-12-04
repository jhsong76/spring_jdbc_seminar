package com.umc.src.Web;


import com.umc.src.Web.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/home")
    public String homepage() {
        return "home";
    }

    @GetMapping("/")
    public String list() {
        return "board/list";
    }

    @GetMapping("/post")
    public String post() {
        return "board/post";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto) {
        boardService.savePost(boardDto);
        return "redirect:/";
    }
}
