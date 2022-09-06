package board.myProj.domain.board;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class BoardRepositoryImpl implements BoardRepository{
    private final JdbcTemplate template;

    public BoardRepositoryImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Board> findAll() {
        String sql = "select * from board";
        return template.query(sql,new RowMapper<Board>(){
            @Override
            public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                Board board = new Board();
                board.setNo(rs.getInt("no"));
                board.setLoginId(rs.getString("loginId"));
                board.setName(rs.getString("name"));
                board.setPassword(rs.getString("password"));
                board.setTitle(rs.getString("title"));
                board.setContent(rs.getString("content"));
                board.setCount(rs.getInt("count"));
                board.setWrite_date(rs.getDate("write_date"));
                return null;
            }
        });
    }
    @Override
    public Board save(Board board) {
            String sql = "insert into Board(loginId, name,password,title, content) values(?,?,?,?,?)";
            template.update(sql, board.getLoginId(), board.getName(), board.getPassword(),board.getTitle(),board.getContent());
            log.info("저장완료!!!!");
            log.info("no={}",board.getNo());
       return board;
    }

    @Override
    public Board findById(String loginId) {
        String sql="select * from Board where loginId = ? ";
        try{
            return template.queryForObject(sql,find(),loginId);

        }
        catch(EmptyResultDataAccessException e){
            return null;
        }

    }        //no, loginId, name, content,password, localdate

    @Override
    public Board findByNo(int no) {
        String sql = "select * from Board where no = ? ";
        try{
            return template.queryForObject(sql,find(),no);

        }
        catch(EmptyResultDataAccessException e){
            return null;
        }    }

    private RowMapper<Board> find(){
        return (rs,rowNum)->{
            Board board = new Board();
            board.setNo(rs.getInt("no"));
            board.setLoginId(rs.getString("loginId"));
            board.setName(rs.getString("name"));
            board.setPassword(rs.getString("password"));
            board.setTitle(rs.getString("title"));
            board.setContent(rs.getString("content"));
            board.setCount(rs.getInt("count"));
            board.setWrite_date(rs.getDate("write_date"));
            return board;
        };
    }


    @Override
    public void updateContent(int no, String content) {
        String sql = "update board set content =? where no=?";
        template.update(sql,content,no);
    }

    @Override
    public void delete(int no) {
        String sql="delete from board where no=?";
        template.update(sql,no);

    }
}
