package com.example.library.member.controller;

import com.example.library.member.domain.MemberVO;
import com.example.library.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String loginForm() {
        return "/member/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        HttpSession session) {

        MemberVO loginMember = memberService.login(email, password);
        log.info("========== loginMember={}", loginMember);
        if (loginMember == null)
            return "redirect:/login";

        session.setAttribute("email", loginMember.getEmail());
        session.setAttribute("nickname", loginMember.getNickname());
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();
        log.info("로그아웃");
        return "redirect:/";
    }
}
