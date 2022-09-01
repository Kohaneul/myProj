package board.myProj;

import board.myProj.domain.connection.ConnectionConst;
import board.myProj.domain.member.Member;
import board.myProj.domain.member.MemberRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import static board.myProj.domain.connection.ConnectionConst.*;

@Component
@RequiredArgsConstructor
public class DataInit {

    private final MemberRepositoryImpl memberRepository;

    @PostConstruct
    public void init(){
//        memberRepository.save(new Member("memberAa","memberAa","11111","서울시 금천구","0103221111"));
//        memberRepository.save(new Member("memberB","memberB","11111","서울시 강남구","01033331111"));
    }



}
