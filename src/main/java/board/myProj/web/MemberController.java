package board.myProj.web;

import board.myProj.domain.member.member.Member;
import board.myProj.domain.member.MemberRepositoryImpl;
import board.myProj.domain.member.member.MemberService;
import board.myProj.domain.member.member.SaveMember;
import board.myProj.domain.member.member.UpdateMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/")
public class MemberController {
    private final MemberRepositoryImpl memberRepository;
    private final MemberService memberService;
    @GetMapping
    public String home(){
        return "index";
    }
    //회원가입
    @GetMapping("/signUp")
    public String save(@ModelAttribute Member member){
        return "/register/addForm";
    }

    @PostMapping("/signUp")
    public String save(@Validated @ModelAttribute("member") SaveMember form, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            log.info("에러발생!!!!");
            log.info("error={}",bindingResult);
            return "/register/addForm";
        }
        if(memberRepository.findByLoginId(form.getLoginId())!=null){
         bindingResult.reject("duplicateId",new Object[]{form.getLoginId()},null);
            return "/register/addForm";
        }
        Member member = memberRepository.save(new Member(form.getId(),form.getName(),form.getLoginId(),form.getPassword(),form.getAddress(),form.getPhoneNumber()));
        log.info("저장 완료!!!");
        redirectAttributes.addAttribute("loginId",member.getLoginId());
        return "redirect:/member/{loginId}";
    }

    @GetMapping("/member/{loginId}")
    public String viewDetail(@PathVariable String loginId, Model model){
        Member member = memberRepository.findByLoginId(loginId);
        model.addAttribute("member",member);
        return "/register/viewForm";
    }


    @GetMapping("/member/all")
    public String memberList(Model model){
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members",members);
        return "/register/viewAll";
    }


    @GetMapping("/member/{loginId}/edit")
    public String updateMember(@PathVariable String loginId, Model model){
        Member member = memberRepository.findByLoginId(loginId);
        model.addAttribute("member",member);
        return "/register/updateForm";
    }

    @PostMapping("/member/{loginId}/edit")
    public String updateMember(@PathVariable String loginId, @Validated @ModelAttribute("member")UpdateMember form,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/register/updateForm";
        }
        Member member = memberRepository.findByLoginId(loginId);
        memberRepository.update(form.getPassword(),form.getAddress(),form.getPhoneNumber(),form.getLoginId());
        return "redirect:/member/{loginId}";
    }

    @GetMapping("/member/{loginId}/delete")
    public String deleteMember(@PathVariable String loginId){
        Member member = memberRepository.findByLoginId(loginId);
        memberRepository.delete(loginId);
        return "redirect:/member/all";
    }

    @GetMapping("/find/id")
    public String findId(@ModelAttribute Member member){
        return "/login/find/idFind";
    }
    @PostMapping("/find/id")
    public String findId(@Validated @ModelAttribute("member") Member findMember,BindingResult bindingResult,Model model){
        Member member = memberRepository.findByLoginId2(findMember.getPassword(), findMember.getPhoneNumber());
        if(member==null){
            bindingResult.addError(new FieldError("member","phoneNumber","값 오류"));
            return "/login/find/idFind";
        }
        if(bindingResult.hasErrors()){
            log.info("error!!!={}",bindingResult);
            return "/login/find/idFind";
        }
        String loginId = memberService.Converter(member.getLoginId());
        model.addAttribute("loginId",loginId);

        return "/login/find/idFind_";
    }

    @GetMapping("/find/password")
    public String findPassword(@ModelAttribute Member member){
        return "/login/find/passwordFind";
    }
    @PostMapping("/find/password")
    public String findPassword(@Validated @ModelAttribute("member") Member findMember, BindingResult bindingResult,Model model){

        Member member = memberRepository.findByPassword(findMember.getLoginId(), findMember.getPhoneNumber());
        if(member==null){
            bindingResult.addError(new FieldError("member","phoneNumber","값 오류"));
            return "/login/find/passwordFind";
        }
        if(bindingResult.hasErrors()){
            return "/login/find/passwordFind";
        }
        String password = memberService.Converter(member.getLoginId());
        model.addAttribute("password",password);
        return "/login/find/passwordFind_";
    }


}
