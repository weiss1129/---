package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o() {
        // given
        Member memberVIP = new Member(1L, "memberVIP", Grade.VIP);

        // when
        int discout = discountPolicy.discount(memberVIP, 10000);

        // then
        assertEquals(discout, 1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야한다")
    void vip_x() {
        // given
        Member member = new Member(1L, "member", Grade.BASIC);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        assertEquals(discount, 0);
    }

}