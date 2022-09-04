package board.myProj.domain.member.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class login {
    @NotEmpty
    private String loginId;
    @NotEmpty
    private String password;
}
