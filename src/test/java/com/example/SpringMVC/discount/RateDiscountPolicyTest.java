package com.example.SpringMVC.discount;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.SpringMVC.member.Grade;
import com.example.SpringMVC.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {
    private DiscountPolicy discountPolicy=new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용되어야 한다.")
    void discout_vip() {
        //given
        Member member = new Member(1L, "최동훈", Grade.VIP);

        int discount = discountPolicy.discout(member, 10000);

        assertThat(discount).isEqualTo(1000);

    }
}