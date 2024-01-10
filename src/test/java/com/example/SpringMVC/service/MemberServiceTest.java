package com.example.SpringMVC.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.SpringMVC.domain.Member;
import com.example.SpringMVC.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void setDB() {
        memberRepository=new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }


    @AfterEach
    void clearDB() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {

        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();

        assertThat(saveId).isEqualTo(findMember.getId());

    }

    @Test
    public void 중복_회원_예제() {
        //given
        Member member1 = new Member();
        member1.setName("최동훈");

        Member member2 = new Member();
        member2.setName("최동훈");

        //when

        //예외 발생 첫방법
//        memberService.join(member1);
//        try {
//            memberService.join(member2);
//            fail();
//
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
//        }
        //추천 바업ㅂ
        memberService.join(member1);
        assertThrows(IllegalStateException.class,()->memberService.join(member2));
    }

    @Test
    void 회원조회() {
    }

    @Test
    void findOne() {
    }
}