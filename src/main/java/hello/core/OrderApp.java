package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrcerService;
import hello.core.order.Order;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl();
//        OrcerService orcerService = new OrderServiceImpl();
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();;
//        OrcerService orcerService = appConfig.orcerService();;

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrcerService orderService = ac.getBean("orderService", OrcerService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP); // 멤버 생성
        memberService.join(member); //메모리에 넣음

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order); //원래가격
        System.out.println("order.calculatePrice() = " + order.calculatePrice()); //할인
    }
}
