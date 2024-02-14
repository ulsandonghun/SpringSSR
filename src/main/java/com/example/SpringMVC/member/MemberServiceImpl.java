package com.example.SpringMVC.member;

public class MemberServiceImpl implements MemberService {
    //DIP 위반 : 객체가 역할(추상화)와 구현(구체화) 모두에 의존하고 있음. 추상화에만 의존해야함.
    private final MemberRepository memberRepository ;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository=memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
