package com.example.SpringMVC.discount;

import com.example.SpringMVC.member.Member;

public interface DiscountPolicy{
    int discout(Member member, int price);
}
