package board.myProj.web.validation;

import board.myProj.domain.member.member.Member;
import board.myProj.domain.member.MemberRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class MemberValidation implements Validator {
    private MemberRepository memberRepository;
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
        if(!StringUtils.hasText(member.getAddress())){
            errors.rejectValue("address","address");
        }

        if(!StringUtils.hasText(member.getPhoneNumber())){
            errors.rejectValue("phoneNumber","phoneNumber");
        }



    }





}
