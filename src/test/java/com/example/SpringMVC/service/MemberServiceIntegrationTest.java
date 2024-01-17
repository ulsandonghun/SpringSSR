package com.example.SpringMVC.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.SpringMVC.domain.Member;
import com.example.SpringMVC.repository.MemberRepository;
import com.example.SpringMVC.repository.MemoryMemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
//테스트 케이스 하나하나마다 해당 테스트 실행후 DB에 저장된
// 값들을 롤백하여서 추후 테스트와 실제 DB에 영향미치지 않게 한다.
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired
    MemberRepository memberRepository;




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