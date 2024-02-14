package com.example.SpringMVC;

import com.example.SpringMVC.member.Grade;
import com.example.SpringMVC.member.Member;
import com.example.SpringMVC.member.MemberService;
import com.example.SpringMVC.member.MemberServiceImpl;
import com.example.SpringMVC.order.AppConfig;
import com.example.SpringMVC.order.Order;
import com.example.SpringMVC.order.OrderService;
import com.example.SpringMVC.order.OrderServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = context.getBean("memberService", MemberService.class);

        OrderService orderService = context.getBean("orderService", OrderService.class);


        Long memberId=1L;
        Member member = new Member(memberId, "최동훈", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
