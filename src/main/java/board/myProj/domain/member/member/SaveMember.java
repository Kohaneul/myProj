package board.myProj.domain.member.member;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class SaveMember {
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
