package com.example.SpringMVC.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    @Operation(summary = "컨텐츠 조회시 사용자 투표 여부 확인", description = "사용자가 해당 컨텐츠를 투표하였다면 투표 결과를, 안했다면 안했다는 결과를 반환합니다.")

    public String home() {
        return "home";
    }

}
