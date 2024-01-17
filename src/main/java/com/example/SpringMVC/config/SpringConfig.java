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
    private EntityManager entityManager;

    @Autowired
    public SpringConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());

    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);

//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(entityManager);
    }
}
