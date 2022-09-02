package board.myProj.web;

import board.myProj.domain.member.member.Member;
import board.myProj.domain.member.MemberRepositoryImpl;
import board.myProj.domain.member.member.SaveMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberRepositoryImpl memberRepository;
    @GetMapping
    public String home(){
        return "index";
    }
    @GetMapping("/save")
    public String save(@ModelAttribute Member member){
        return "/register/addForm";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("member") SaveMember form, BindingResult bindingResult, RedirectAttributes redirectAttributes){
//        if(memberRepository.findByLoginId(form.getLoginId())!=null){
//            bindingResult.reject("duplicateId",new Object[]{form.getLoginId()},null);
//        }
        if(bindingResult.hasErrors()){
            log.info("에러발생!!!!");
            log.info("error={}",bindingResult);
            return "/register/addForm";
        }
        Member member = memberRepository.save(new Member(form.getId(),form.getName(),form.getLoginId(),form.getPassword(),form.getAddress(),form.getPhoneNumber()));
        log.info("저장 완료!!!");
        redirectAttributes.addAttribute("loginId",member.getLoginId());
        return "redirect:/member/{loginId}";
    }

    @GetMapping("/{loginId}")
    public String viewDetail(@PathVariable String loginId, Model model){
        Member member = memberRepository.findByLoginId(loginId);
        model.addAttribute("member",member);
        return "/register/viewForm";
    }

    @GetMapping("/duplicateCheck")
    public String duplicateCheck(@RequestParam String loginId, HttpServletRequest request){
        Member member = memberRepository.findByLoginId(loginId);
        if(member==null){
            return "/register/addForm";
        }
        HttpSession session = request.getSession();
        session.setAttribute("loginId",loginId);
        return "register/duplicateCheck";
    }

    @GetMapping("/all")
    public String memberList(Model model){
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members",members);
        return "/register/viewAll";
    }
//
//    @GetMapping("/duplicateCheckPassword")
//    public String duplicatePassword(@RequestParam String password){
//        return "";
//    }




}
