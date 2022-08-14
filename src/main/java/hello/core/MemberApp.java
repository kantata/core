package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService(); // memberServiceImpl

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); //Bean 관리
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);// 빈이름(AppConfig.memberService), 타입

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member); // 회원가입

        Member findMember = memberService.findMember(1L); // 가입된 멤버 조회
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
