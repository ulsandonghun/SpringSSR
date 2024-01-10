package com.example.SpringMVC.repository;

import com.example.SpringMVC.domain.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository {


    //문제상황 여기서는 실질적으로 저장되고 있는 Map은 Static이라서 클래스에 붙
    //어있는것이라 인스턴스가 바뀌어도 같은값이지만 나약 static이 아닌경우
    //같은 레포지토리 인스턴스를 호출하지 않으면 엉뚱한 DB를 호출하는 꼴이
    //되기때문에 생성자로 하나의 레포지토리만 쓰도록 Service에서 강제한다.
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
