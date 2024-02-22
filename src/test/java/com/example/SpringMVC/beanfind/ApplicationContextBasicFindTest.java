package com.example.SpringMVC.beanfind;

import com.example.SpringMVC.member.MemberService;
import com.example.SpringMVC.member.MemberServiceImpl;
import com.example.SpringMVC.order.AppConfig;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회한다")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }


    @Test
    @DisplayName("빈 이름으로 조회안될 경우 예외를 터트린다.")
    void findBeanByNameX() {
        Assertions.assertThatThrownBy(()-> ac.getBean("xxxxx")).isInstanceOf(NoSuchBeanDefinitionException.class);



    }
}
