package board.myProj.domain.member.member;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class SaveMember {
    private int id;
    @NotEmpty
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,10}$", message = "이름은 특수문자를 제외한 2~10자리여야 합니다.")
    private String name;
    @NotEmpty
    private String loginId;
    @NotEmpty
    @Pattern(regexp = "\\d{5,10}$", message = "비밀번호는 5자리 이상 10자리 미만의 수를 사용하세요.")
    private String password;
    @NotEmpty
    @Length(min = 5,max = 30)
    private String address;
    @NotEmpty
    @Pattern(regexp = "^\\d{3}\\d{3,4}\\d{4}$",message = "휴대폰 번호 양식은 00000000000입니다.")
    private String phoneNumber;

}
