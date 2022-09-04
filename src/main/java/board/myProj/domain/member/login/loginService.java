package board.myProj.domain.member.login;

import board.myProj.domain.member.MemberRepository;
import board.myProj.domain.member.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import javax.xml.stream.StreamFilter;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class loginService {
    private final MemberRepository memberRepository;

   public  Member adminLogin(String loginId, String password) {
        Member member = memberRepository.findByLoginId(loginId);
        if(member!=null){
            if(member.getPassword().equals(password)){
                return member;
            }
        }
        return null;
    }


}
