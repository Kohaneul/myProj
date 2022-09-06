package board.myProj.domain.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.context.assertj.ApplicationContextAssertProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@TestConfiguration
class BoardRepositoryImplTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BoardRepositoryImpl.class);
    @Autowired private DataSource dataSource;

    @Test
    void test(){
        BoardRepositoryImpl bean = ac.getBean(BoardRepositoryImpl.class);
        Board board = new Board();
        board.
    }


}