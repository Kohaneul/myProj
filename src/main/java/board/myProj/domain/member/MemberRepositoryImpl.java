package board.myProj.domain.member;

import board.myProj.domain.member.member.Member;
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
                member.setId(rs.getInt("id"));
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
        String sql = "insert into Member(name,loginId,password,address,phoneNumber) values(?,?,?,?,?)";
        template.update(sql,form.getName(),form.getLoginId(),form.getPassword(),form.getAddress(),form.getPhoneNumber());
        return form;
    }

    @Override
    public Member findById(int id) {
        String sql = "select * from member where id=?";
        log.info("id={}",id);
        return template.queryForObject(sql,find(),id);
    }


    @Override
    public Member findByLoginId(String loginId){
        String sql = "select * from member where loginId=?";
        log.info("loginId={}",loginId);
        return template.queryForObject(sql,find(),loginId);
    }


    private RowMapper<Member> find(){
        return (rs,rowNum)->{
            Member member = new Member();
            member.setId(rs.getInt("id"));
            member.setName(rs.getString("name"));
            member.setLoginId(rs.getString("loginid"));
            member.setPassword(rs.getString("password"));
            member.setAddress(rs.getString("address"));
            member.setPhoneNumber(rs.getString("phonenumber"));
            return member;

        };
    }

    @Override
    public void update(String password, String address, String phoneNumber,String loginId) {
        String sql = "update member set password=?, address=?, phoneNumber=? where loginId=?";
        log.info("loginId={}",loginId);
        template.update(sql,password,address,phoneNumber,loginId);
    }

    @Override
    public void delete(Long id){
        String sql = "delete from member where id=?";
        log.info("delete id={}",id);
        template.update(sql,id);
    }

}
