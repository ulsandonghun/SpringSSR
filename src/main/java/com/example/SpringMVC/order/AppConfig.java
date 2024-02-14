package com.example.SpringMVC.order;

import com.example.SpringMVC.discount.DiscountPolicy;
import com.example.SpringMVC.discount.FixDiscountPolicy;
import com.example.SpringMVC.member.MemberRepository;
import com.example.SpringMVC.member.MemberService;
import com.example.SpringMVC.member.MemberServiceImpl;
import com.example.SpringMVC.member.MemoryMemberReposotiry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    private static MemberRepository memberRepository() {
        return new MemoryMemberReposotiry();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
