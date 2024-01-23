package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor // lombok 생성자 자동 생성
public class OrderServiceImpl implements OrderService {

    // 필드 주입
    // 이젠 쓰지말자... 안티 패턴
    // Test시에 막막해진다 -> Test 환경에서 단위모듈에 대한 테스트가 불가함
    // Test 코드에서 사용하거나, Cofig 파일에서는 사용 무방... 하지만 Config 에서도 다른 방법이 있다...
//    @Autowired
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // setter 주입
    // 의존관계 변경 가능성 또는 선택적으로 의존주입 해줄 때 사용
//    @Autowired(required = false) // 필수가 아닐 때
//    public void setMemberRepository(MemberRepository memberRepository) {
//        System.out.println("memberRepository = " + memberRepository);
//        this.memberRepository = memberRepository;
//    }

//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("discountPolicy = " + discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }

    // 생성자 주입... 필수적으로 의존관계 주입
    // 거의 생성자 주입을 쓴다
    @Autowired // 생략가능. 생성자 하나만 있을때는
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        // 생성자 주입 vs setter 주입
        // 순서는 보장되지 않는다
        System.out.println("1. memberRepository = " + memberRepository);
        System.out.println("1. discountPolicy = " + discountPolicy);
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // Test 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
