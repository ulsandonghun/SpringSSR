package com.example.SpringMVC.order;

import com.example.SpringMVC.discount.DiscountPolicy;
import com.example.SpringMVC.discount.FixDiscountPolicy;
import com.example.SpringMVC.member.Member;
import com.example.SpringMVC.member.MemberRepository;
import com.example.SpringMVC.member.MemoryMemberReposotiry;

public class OrderServiceImpl implements OrderService{
    private  final MemberRepository memberRepository = new MemoryMemberReposotiry();
    private  final DiscountPolicy discountPolicy = new FixDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discout = discountPolicy.discout(member, itemPrice);
        return new Order(memberId,itemName,itemPrice,discout);
    }
}
