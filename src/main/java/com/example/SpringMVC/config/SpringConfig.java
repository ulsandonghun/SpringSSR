package com.example.SpringMVC.config;

import com.example.SpringMVC.repository.JdbcMemberRepository;
import com.example.SpringMVC.repository.JdbcTemplateMemberRepository;
import com.example.SpringMVC.repository.JpaMemberRepository;
import com.example.SpringMVC.repository.MemberRepository;
import com.example.SpringMVC.repository.MemoryMemberRepository;
import com.example.SpringMVC.service.MemberService;
import jakarta.persistence.EntityManager;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;

    @Autowired
    //생성자가 하나인 경우는 Autowired 생략 가능.
    public SpringConfig(MemberRepository memberRepository) {
        //의문점 ? spring Data JPA 는등록이 되지 않았는데 ?
        //extends로 JPArepository<>를 상속하면 스프링이 알아서 구현해서 빈으로 등록 해준다.

        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);

    }

//    @Bean
//    public MemberRepository memberRepository() {
////        return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource);
//
////        return new JdbcTemplateMemberRepository(dataSource);
////        return new JpaMemberRepository(entityManager);
//    }
}
