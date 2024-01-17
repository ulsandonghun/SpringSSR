package com.example.SpringMVC.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //공통화할수 없는 아래의 필드 ex)name 이나 다른 비즈니스로직으로 username 동
    //다 다르기 때문에 JPARepository<>에서 새롭게 구현해 줘야 한다.
    private String name;

}
