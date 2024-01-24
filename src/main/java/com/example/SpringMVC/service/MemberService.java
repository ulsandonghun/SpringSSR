package com.example.SpringMVC.service;

import com.example.SpringMVC.domain.Member;
import com.example.SpringMVC.repository.MemberRepository;
import com.example.SpringMVC.repository.MemoryMemberRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class MemberService {

    private final MemberRepository memberRepository;

    //이렇게 클래스가 직접 repository를 생성하는게 아니라 외부에서 주입받는것을
    //의존 주입 이라고 합.
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     *
     * @return
     */
    public Long join(Member member) {

        //중복회원 불가
        validateDuplicateMember(member);
        //중복회원 검증
        //orElseGet 사용

        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(
                        member1 -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다");
                        }
                );
    }

    public List<Member> findMembers() {

        return memberRepository.findAll();

    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
