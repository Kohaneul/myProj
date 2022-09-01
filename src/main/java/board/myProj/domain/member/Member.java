package board.myProj.domain.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class Member {
    private String name,loginId,password,address,phoneNumber;

    public Member(String loginId, String password, String name, String address, String phoneNumber){
        this.name = name;
        this.loginId = loginId;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

}
