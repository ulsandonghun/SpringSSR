package com.example.SpringMVC.member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
