package com.example.SpringMVC;

import com.example.SpringMVC.member.Grade;
import com.example.SpringMVC.member.Member;
import com.example.SpringMVC.member.MemberServiceImpl;
import com.example.SpringMVC.order.Order;
import com.example.SpringMVC.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        MemberServiceImpl memberService = new MemberServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl();

        Long memberId=1L;
        Member member = new Member(memberId, "최동훈", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
