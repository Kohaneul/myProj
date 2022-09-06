package board.myProj.domain.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    private Integer no,count;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date write_date;
    private String loginId,password,name,title,content;


}
