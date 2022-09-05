package board.myProj.domain.board;

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
@Repository
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
                board.setContent(rs.getString("content"));
                board.setPassword(rs.getString("password"));
                return null;
            }
        });
    }

    @Override
    public Board save(Board board) {
        try {
            String sql = "insert into Board(loginId, name, content, password,localDate) values(?,?,?,?,?)";
            template.update(sql, board.getLoginId(), board.getName(), board.getContent(), board.getPassword(),LocalDateTime.now());
            return board;
        }
        catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public Board findById(int id) {
        try{
            String sql="select * from Board where loginId = ? ";
           return template.queryForObject(sql,find(),id);
        }
        catch(EmptyResultDataAccessException e){
            return null;
        }
    }        //no, loginId, name, content,password, localdate

    @Override
    public Board findByNo(int no) {
        try{
            String sql="select * from Board where no = ? ";
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
            board.setContent(rs.getString("content"));
            board.setPassword(rs.getString("password"));
            board.setLocalDateTime((LocalDateTime) rs.getObject("localDateTime"));
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
