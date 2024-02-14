package com.example.SpringMVC.member;

import com.example.SpringMVC.order.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void init() {
        AppConfig appConfig = new AppConfig();

        this.memberService= appConfig.memberService();
    }

    @Test
    void join() {
        //given
        Member member = new Member(1L, "최동훈", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
