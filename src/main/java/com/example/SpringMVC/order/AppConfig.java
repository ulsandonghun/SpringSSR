package com.example.SpringMVC.order;

import com.example.SpringMVC.discount.FixDiscountPolicy;
import com.example.SpringMVC.member.MemberService;
import com.example.SpringMVC.member.MemberServiceImpl;
import com.example.SpringMVC.member.MemoryMemberReposotiry;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberReposotiry());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberReposotiry(), new FixDiscountPolicy());
    }

}
