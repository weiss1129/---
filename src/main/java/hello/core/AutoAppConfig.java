package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = {"hello.core.member", "hello.core.discount"},
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
// basePackageClasses 지정하지 않을 시 @ComponentScan 이 붙은 설정 정보 클래스의 패키지가 시작 위치
// basePackageClasses는 통상 지정하지 않고 프로젝트 패키지 구조 최상단에...
public class AutoAppConfig {

    // 이 경우 수동 빈 등록이 우선권을 가진다.
    // 수동 빈이 자동 빈을 오버라이딩
    // 에러가 나도록 스프링부트에서 최근 바뀜...
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
