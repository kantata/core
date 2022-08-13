package hello.core.discount;

import hello.core.member.Member;

/**
 * 추상(인터페이스) 의존
 */
public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
