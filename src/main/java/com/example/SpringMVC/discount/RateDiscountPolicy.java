package com.example.SpringMVC.discount;

import com.example.SpringMVC.member.Grade;
import com.example.SpringMVC.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent=10;

    @Override
    public int discout(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price*discountPercent/100;
        }
        return 0;
    }
}
