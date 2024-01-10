package com.example.SpringMVC.service;

import com.example.SpringMVC.domain.Member;
import com.example.SpringMVC.repository.MemberRepository;
import com.example.SpringMVC.repository.MemoryMemberRepository;
import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

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
