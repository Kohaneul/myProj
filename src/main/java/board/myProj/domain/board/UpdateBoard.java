package board.myProj.domain.board;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class UpdateBoard {

    //no, loginId, name, content,password, localdate
    @NotNull
    private Long no;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate localDate;
    @NotEmpty
    private String loginId,name,content,password;

}
