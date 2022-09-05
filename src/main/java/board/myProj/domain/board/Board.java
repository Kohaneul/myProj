package board.myProj.domain.board;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Board {
//no,localDateTime,loginId,name,content,password
    @NotNull
    private Integer no;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localDateTime;

    @NotEmpty
    private String loginId,name,content,password;


}
