package board.myProj.domain.member;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public interface MemberRepository {
    List<Member> findAll();

    Member save(Member member);



    Member findByLoginId(String loginId);

    void update(String password, String address, String phoneNumber,String loginId);

    void delete(String loginId);


}
