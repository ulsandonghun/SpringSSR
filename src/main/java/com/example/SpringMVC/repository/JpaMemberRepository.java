package com.example.SpringMVC.repository;

import com.example.SpringMVC.domain.Member;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class JpaMemberRepository implements MemberRepository{
    private final EntityManager entityManager;

    @Autowired
    public JpaMemberRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Member save(Member member) {
         entityManager.persist(member);
         return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = entityManager.find(Member.class, id);
        //중요 : PK기반 검색이 아닌 경우 JPQL을 직접 작성해야됨.(findbyName이나 findAll 같은 경우)
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> resultList = entityManager.createQuery("select m from Member m where m.name=name", Member.class)
                .getResultList();
        return resultList.stream().findAny();
    }

    @Override
    public List<Member> findAll() {

        //ctrl+art+shift+t 한후 inline 하면 합쳐짐.
        return entityManager.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
