package board.myProj.domain.member;

import board.myProj.domain.connection.ConnectionConst;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import static board.myProj.domain.connection.ConnectionConst.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    private MemberRepository memberRepository;
    private static Long sequence=0L;
    @BeforeEach
    void init(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL,USERNAME,PASSWORD);
        memberRepository = new MemberRepository(dataSource);
        memberRepository.save(new Member(++sequence,"memberA","memberA","1234","서울시 중구","0102214"));

    }
}