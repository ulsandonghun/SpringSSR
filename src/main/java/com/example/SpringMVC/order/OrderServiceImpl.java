package com.example.SpringMVC.order;

import com.example.SpringMVC.discount.DiscountPolicy;
import com.example.SpringMVC.member.Member;
import com.example.SpringMVC.member.MemberRepository;
import lombok.RequiredArgsConstructor;


public class OrderServiceImpl implements OrderService{
    private   MemberRepository memberRepository;
//    private  final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private  DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discout = discountPolicy.discout(member, itemPrice);
        return new Order(memberId,itemName,itemPrice,discout);
    }


}
