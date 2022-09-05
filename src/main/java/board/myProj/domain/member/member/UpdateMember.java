package board.myProj.domain.member.member;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UpdateMember {
    @NotNull
    private int id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String loginId;
    @NotEmpty
    private String password;
    @NotEmpty
    @Length(min = 5,max = 30)
    private String address;
    @NotEmpty
    @Length(max = 15)
    private String phoneNumber;
}
