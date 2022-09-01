package board.myProj.domain.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotEmpty;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberForm {

    @NotEmpty(message = "빈 값은 허용하지 않습니다.")
    @Length(max = 10,message = "글자수는 10자리까지 허용합니다.")
    private String name,loginId,password,passwordCheck;

    @NotEmpty(message = "빈 값은 허용하지 않습니다.")
    @Length(max = 30,message = "글자수는 30자리까지 허용합니다.")
    private String address,phoneNumber;


}
