package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // memberService가 MemberServiceImpl의 인스턴스면 성공
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // memberService가 MemberServiceImpl의 인스턴스면 성공
    }

    @Test
    @DisplayName("구체 타입으로 조회") // 구현으로 조회하는것은 바람직하진 않음
    void findBeanByName2() {
        MemberService memberService = ac.getBean("memberService",MemberServiceImpl.class); // MemberServiceImpl (구현)
        System.out.println("memberService.getClass() = " + memberService.getClass());

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // memberService가 MemberServiceImpl의 인스턴스면 성공
    }

    @Test // 실패 테스트
    @DisplayName("빈 이름으로 조회 X")
    void findBeanByNameX() { // 에러발생시 예외처리방법
        MemberService xxxx = ac.getBean("xxxx", MemberService.class);
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", MemberService.class)); // ac.getBean 실행 시 예외가 NoSuchBeanDefinitionException으로 나와야지 성공
    }

}
