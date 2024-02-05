package com.example.SpringMVC.discount;

import com.example.SpringMVC.member.Grade;
import com.example.SpringMVC.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000;
    @Override
    public int discout(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        return 0;
    }
}
