package board.myProj.domain.member.member;

import board.myProj.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {


    public String Converter(String data) {
        int len = data.length();
        StringBuffer str = new StringBuffer();
        int no = 3;
        if(len<=5){ no = 1;}
        for (int i = 0; i < len; i++) {
            char c = data.charAt(i);
                if (i < no || i == len - 1) {
                    str.append(c);
                }
                else{ str.append("*");}
                }
        return str.toString();
    }

}
