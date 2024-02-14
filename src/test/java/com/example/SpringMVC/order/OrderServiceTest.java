package com.example.SpringMVC.order;

import static org.assertj.core.api.Assertions.*;

import com.example.SpringMVC.member.Grade;
import com.example.SpringMVC.member.Member;
import com.example.SpringMVC.member.MemberRepository;
import com.example.SpringMVC.member.MemberService;
import com.example.SpringMVC.member.MemberServiceImpl;
import com.example.SpringMVC.member.MemoryMemberReposotiry;
import net.bytebuddy.asm.MemberSubstitution.Argument;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    private  OrderService orderService ;
    private MemberService memberService ;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        this.orderService= appConfig.orderService();
        this.memberService= appConfig.memberService();
    }


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
