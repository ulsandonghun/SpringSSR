package com.example.SpringMVC.repository;

import com.example.SpringMVC.domain.Member;
import java.util.Optional;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
    //select m from Member m where m.name = ? 이렇게 짜줌.
    //특히 공통의 로직이 아닌 프로젝트별로 다르게 설정한 엔티티들의 필드 (ex. playlistID)
    //등은 이렇게 등록을 해 주어야 함.
    //findByNameAndId 이렇게 JPQL 규칙이 존재함.
}
