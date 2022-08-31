package board.myProj.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
@Slf4j
public class MemberRepository {
    private final JdbcTemplate template;

    public MemberRepository(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public Member save(Member member){
        String sql = "insert into member values(?,?,?,?,?,?)";
        template.update(sql,member.getId(),member.getLoginId(),member.getPassword(),member.getAddress(),member.getAddress());
        return member;
    }

    public Member findById(Long id){
        String sql = "select * from member where id=?";
        log.info("findId={}",findId());
        return  template.queryForObject(sql, findId(), id);
    }

    private RowMapper<Member> findId(){
        return (rs,rowNum)->{
          Member member = new Member();
          member.setId(rs.getLong("id"));
          member.setLoginId(rs.getString("loginId"));
          member.setPassword(rs.getString("password"));
          member.setAddress(rs.getString("address"));
          member.setPhoneNumber(rs.getString("phoneNumber"));
            return member;
        };
    }

    public Member findByLoginId(String loginId){
        String sql = "select * from member where loginId=?";
        log.info("loginId={}",loginID());
        return template.queryForObject(sql,loginID(),loginId);
    }

    private RowMapper<Member> loginID(){
        return (rs,rowNum)->{
            Member member = new Member();
            member.setId(rs.getLong("id"));
            member.setLoginId(rs.getString("loginId"));
            member.setPassword(rs.getString("password"));
            member.setAddress(rs.getString("address"));
            member.setPhoneNumber(rs.getString("phoneNumber"));
            return member;
        };
    }

    public void update(String password, String address, String phoneNumber,String loginId) {
        String sql = "update member set password=?, address=?, phoneNumber=? where loginId=?";
        log.info("loginId={}",loginId);
        template.update(sql,password,address,phoneNumber,loginId);
    }

    public void delete(Long id){
        String sql = "delete from member where id=?";
        log.info("id={}",id);
        template.update(sql,id);
    }

}
