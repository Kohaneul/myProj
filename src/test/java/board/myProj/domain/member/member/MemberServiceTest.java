package board.myProj.domain.member.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.assertj.ApplicationContextAssertProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

import java.text.Annotation;

import static org.junit.jupiter.api.Assertions.*;
class MemberServiceTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MemberService.class);

    @Test
    public void test111(){
        MemberService bean = ac.getBean(MemberService.class);
        String data1 = bean.Converter("memberA");
        Assertions.assertThat(data1).isEqualTo("mem***A");

    }


}