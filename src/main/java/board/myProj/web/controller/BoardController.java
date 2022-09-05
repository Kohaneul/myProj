package board.myProj.web.controller;

import board.myProj.domain.board.Board;
import board.myProj.domain.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping ("/board")
public class BoardController {
    private final BoardRepository boardRepository;

    @GetMapping("/add")
    public String upload(@ModelAttribute Board board){
    return "board/addForm";
    }

    @PostMapping("/add")
    public String upload(@Validated @ModelAttribute Board board, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "board/addForm";
        }
        redirectAttributes.addAttribute("no",board.getNo());
        return "redirect:/board/{no}";
    }

    @GetMapping("/{no}")
    public String findByContent(@PathVariable Integer no, Model model){
        Board board = boardRepository.findByNo(no);
        model.addAttribute("board",board);
        return "board/viewForm";
    }



}
