package board.myProj.web.controller;

import board.myProj.domain.board.Board;
import board.myProj.domain.board.BoardRepository;
import board.myProj.domain.board.BoardRepositoryImpl;
import board.myProj.domain.board.SaveBoard;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping ("/board")
@Slf4j
public class BoardController {
    private final BoardRepository boardRepository;


    @GetMapping("/all")
    public String viewAll(Model model){
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards",boards);
        return "board/viewAll";
    }

    @GetMapping("/add")
    public String upload(@ModelAttribute Board board){
    return "board/addForm";
    }


    @PostMapping("/add")
    public String upload(@Validated @ModelAttribute("board") SaveBoard savedBoard, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpServletRequest request){
        if(bindingResult.hasErrors()){
            log.info("에러내용 ={} ",bindingResult);
            return "board/addForm";
        }
        //loginId, name,password,title, content
        Board save = boardRepository.save( new Board(savedBoard.getNo(),savedBoard.getCount(),savedBoard.getWrite_date(), savedBoard.getLoginId(),savedBoard.getPassword(), savedBoard.getName(),savedBoard.getTitle(),savedBoard.getContent()));
        log.info("info={}",save.getNo());
        redirectAttributes.addAttribute("no",save.getNo());
        return "redirect:/board/{no}";
    }

    @GetMapping("/{no}")
    public String findByContent(@PathVariable Integer no, Model model){
        Board board = boardRepository.findByNo(no);
        model.addAttribute("board",board);
        return "board/viewForm";
    }



}
