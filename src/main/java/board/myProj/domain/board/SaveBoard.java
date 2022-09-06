package board.myProj.domain.board;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class SaveBoard {

    //no, loginId, name, content,password, localdate
    private Integer no,count;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date write_date;
    @NotNull
    private String loginId,name,title,content;
    @NotNull
    @Pattern(regexp = "\\d{4}$", message = "비밀번호는 4자리의 숫자를 사용하세요.")
    private String password;


}
