package com.example.SpringMVC;

import com.example.SpringMVC.member.Grade;
import com.example.SpringMVC.member.Member;
import com.example.SpringMVC.member.MemberService;
import com.example.SpringMVC.member.MemberServiceImpl;
import com.example.SpringMVC.order.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = context.getBean("memberService", MemberService.class);


        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new Member ="+ member.getName());
        System.out.println("find Member ="+ findMember.getName());;


    }
}
