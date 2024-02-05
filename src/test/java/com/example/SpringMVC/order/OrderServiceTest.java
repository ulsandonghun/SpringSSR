package com.example.SpringMVC.order;

import static org.assertj.core.api.Assertions.*;

import com.example.SpringMVC.member.Grade;
import com.example.SpringMVC.member.Member;
import com.example.SpringMVC.member.MemberRepository;
import com.example.SpringMVC.member.MemberService;
import com.example.SpringMVC.member.MemberServiceImpl;
import com.example.SpringMVC.member.MemoryMemberReposotiry;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    private final OrderService orderService = new OrderServiceImpl();
    private final MemberService memberService = new MemberServiceImpl();

    private final MemberRepository memberRepository = new MemoryMemberReposotiry();

    @Test
    public void orderCreate() {
        //given
        Member member = new Member(1L, "최동훈", Grade.VIP);
        memberService.join(member);


        //when
        Order order = orderService.createOrder(1L, "에스랩", 2000);


        //then
        assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }

}
