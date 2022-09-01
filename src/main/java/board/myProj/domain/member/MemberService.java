package board.myProj.domain.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void bizLogic(String loginId){
        Member registerMember = memberRepository.findByLoginId(loginId);
        Validation(registerMember);
        memberRepository.save(registerMember);
    }

    private void Validation(Member member){
        if(member==null){
            throw new RuntimeException("회원가입 중 오류 발생!!!");
        }
    }

    public String duplicatedLoginId(String loginID){
        String message= null;
        if(memberRepository.findByLoginId(loginID)!=null){
            message= "아이디 중복";
        }
        return message;
    }


}
