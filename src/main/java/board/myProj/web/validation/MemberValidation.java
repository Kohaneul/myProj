package board.myProj.web.validation;

import board.myProj.domain.member.login.login;
import board.myProj.domain.member.member.Member;
import board.myProj.domain.member.MemberRepository;
import board.myProj.domain.member.member.SaveMember;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Component
public class MemberValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Member.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Member member = (Member) target;

        if(!StringUtils.hasText(member.getLoginId())){
            errors.rejectValue("loginId","loginId");
        }
        if(!StringUtils.hasText(member.getName())){
            errors.rejectValue("name","name");
        }
        if(!StringUtils.hasText(member.getPassword())){
            errors.rejectValue("password","password");
        }
        if(!StringUtils.hasText(member.getPassword())){
            errors.rejectValue("passwordCheck","passwordCheck");
        }
        if(!StringUtils.hasText(member.getAddress())){
            errors.rejectValue("address","address");
        }

        if(!StringUtils.hasText(member.getPhoneNumber())){
            errors.rejectValue("phoneNumber","phoneNumber");
        }
    }



}
