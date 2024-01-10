package com.example.SpringMVC.controller;


import com.example.SpringMVC.domain.Member;
import com.example.SpringMVC.service.MemberService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    private final MemberService memberService;

    //Controller라고 붙여있어서 스프링이 뜰때 스프링 컨테이너 내부
    //빈 객체로 생성한다.
    //이때 빈 객체로 Controller를 생성할려면, 생성자를 사용해야 한다.
    //만약 이때 생성자에 @Autowired가 붙여져 있으면 해당 클래스 타입이
    //스프링 컨테이너에 등록되어있는지 체크하고 있다면 자동으로 의존주입해준다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }g
}
