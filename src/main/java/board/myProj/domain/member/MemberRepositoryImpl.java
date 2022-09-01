package board.myProj.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
public class MemberRepositoryImpl implements MemberRepository{
    private final JdbcTemplate template;

    public MemberRepositoryImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Member> findAll(){
        String sql = "select * from member";
        return template.query(sql, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
                Member member = new Member();
                member.setName(rs.getString("name"));
                member.setLoginId(rs.getString("loginId"));
                member.setPassword(rs.getString("password"));
                member.setAddress(rs.getString("address"));
                member.setPhoneNumber(rs.getString("phoneNumber"));
                return member;            }
        });
    }


    @Override
    public Member save(Member form){
        String sql = "insert into member(name,loginId,password,address,phoneNumber) values(?,?,?,?,?)";
        Member member = new Member(form.getName(),form.getLoginId(),form.getPassword(),form.getAddress(),form.getPhoneNumber());
        template.update(sql,member);
        return member;
    }

    private RowMapper<Member> find(){
        return (rs,rowNum)->{
                Member member = new Member();
                member.setName(rs.getString("name"));
                member.setLoginId(rs.getString("loginId"));
                member.setPassword(rs.getString("password"));
                member.setAddress(rs.getString("address"));
                member.setPhoneNumber(rs.getString("phoneNumber"));
                return member;

            };
    }



    @Override
    public Member findByLoginId(String loginId){
        String sql = "select * from member where loginId=?";
        log.info("loginId={}",loginId);
        return template.queryForObject(sql,find(),loginId);
    }

    @Override
    public void update(String password, String address, String phoneNumber,String loginId) {
        String sql = "update member set password=?, address=?, phoneNumber=? where loginId=?";
        log.info("loginId={}",loginId);
        template.update(sql,password,address,phoneNumber,loginId);
    }

    @Override
    public void delete(String loginId){
        String sql = "delete from member where loginId=?";
        log.info("loginId={}",loginId);
        template.update(sql,loginId);
    }

}
