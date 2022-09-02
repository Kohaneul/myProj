package board.myProj;

import board.myProj.domain.member.MemberRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class DataInit {

    private final MemberRepositoryImpl memberRepository;

    @PostConstruct
    public void init(){
//        memberRepository.save(new Member(1L,"memberAa","memberAa","11111","서울시 금천구","0103221111"));
//        memberRepository.save(new Member(2L,"memberB","memberB","11111","서울시 강남구","01033331111"));
    }



}
