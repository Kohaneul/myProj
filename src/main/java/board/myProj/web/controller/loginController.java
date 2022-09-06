package board.myProj.web.controller;

import board.myProj.domain.Const.SessionConst;
import board.myProj.domain.member.login.login;
import board.myProj.domain.member.login.loginService;
import board.myProj.domain.member.member.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@Slf4j
@RequiredArgsConstructor
public class loginController {
    private final loginService loginService;

    @GetMapping("/login")
    public String login(@ModelAttribute login login){
        return "/login/loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute login login, BindingResult bindingResult,HttpServletRequest request){

        if(bindingResult.hasErrors()){
            return "/login/loginForm";
        }
        Member member = loginService.adminLogin(login.getLoginId(),login.getPassword());
        if(member==null){
            bindingResult.reject("loginFail","아이디 또는 비밀번호가 맞지 않아유");
            return "/login/loginForm";
        }
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER,member);
        log.info("******* session={},info={},name={}",session.getAttribute(SessionConst.LOGIN_MEMBER).getClass(),session.getAttribute(SessionConst.LOGIN_MEMBER),SessionConst.LOGIN_MEMBER);


        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logOut(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session!=null){
            log.info("sessionMember={}",session.getAttribute(SessionConst.LOGIN_MEMBER));
            log.info("session DELETE!!={}");
            session.invalidate();
        }

        return "redirect:/";

    }


}
