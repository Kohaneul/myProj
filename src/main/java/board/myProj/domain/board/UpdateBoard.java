package board.myProj.domain.board;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UpdateBoard {

    //no, loginId, name, content,password, localdate
    @NotNull
    private Integer no;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localDateTime;
    @NotEmpty
    private String loginId,name,content,password;

}
