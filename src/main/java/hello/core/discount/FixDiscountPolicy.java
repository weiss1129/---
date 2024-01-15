package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discoutFixAmount = 1000; //1000원 정액 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discoutFixAmount;
        } else {
            return 0;
        }
    }
}
