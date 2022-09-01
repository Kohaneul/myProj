package board.myProj.web.validation;

import board.myProj.domain.member.MemberForm;
import board.myProj.domain.member.MemberRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class MemberValidation implements Validator {
    @Autowired private MemberRepositoryImpl memberRepository;
    @Override
    public boolean supports(Class<?> clazz) {
        return MemberForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MemberForm member = (MemberForm) target;

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
        if(!StringUtils.hasText(member.getPasswordCheck())){
            errors.rejectValue("passwordCheck","passwordCheck");
        }
        if(!StringUtils.hasText(member.getPhoneNumber())){
            errors.rejectValue("phoneNumber","phoneNumber");
        }

    }





}
