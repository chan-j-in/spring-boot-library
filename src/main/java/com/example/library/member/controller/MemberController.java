package com.example.library.member.controller;

import com.example.library.member.domain.MemberVO;
import com.example.library.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String joinForm() {
        return "/member/join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute MemberVO member, RedirectAttributes rttr) {

        log.info("========== joinMember={}", member);
        if (memberService.join(member))
            rttr.addAttribute("result", "회원 가입 완료");
        return "redirect:/login";
    }

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


    @GetMapping("/modify")
    public String modifyForm(HttpSession session, Model model) {

        String email = (String) session.getAttribute("email");
        if (email == null) {
            return "redirect:/login"; // 로그인 페이지로 리다이렉트
        }

        MemberVO member = memberService.get(email,true);
        if (member == null) {
            return "redirect:/"; // 메인 페이지로 리다이렉트
        }

        model.addAttribute("member", member);
        return "/member/modify";
    }

    @PostMapping("/modify")
    public String modify(@ModelAttribute MemberVO member, RedirectAttributes rttr) {

        log.info("========== modifyMember={}", member);
        if (memberService.modify(member))
            rttr.addAttribute("result", "회원 정보 수정 완료");
        return "redirect:/";
    }

    @PostMapping("/getEmail")
    @ResponseBody
    public int getEmail(@RequestParam("email") String email) {

        log.info("========== duplication EmailCheck member={}", email);
        MemberVO findMember = memberService.get(email, true);
        int result = (findMember == null) ? 0:1;
        log.info("Result for email {}: {}", email, result);
        return result;
    }

    @PostMapping("/getNickname")
    @ResponseBody
    public ResponseEntity<Map<String, Integer>> getNickname(@RequestParam("nickname") String nickname) {
        log.info("========== duplication NicknameCheck member={}", nickname);
        MemberVO findMember = memberService.get(nickname, false);

        // 추가 로그
        if (findMember != null) {
            log.info("Member found: {}", findMember); // 존재하는 경우의 로그
        } else {
            log.info("No member found with nickname: {}", nickname); // 존재하지 않는 경우의 로그
        }

        int result = (findMember == null) ? 0 : 1; // 닉네임이 없으면 0, 있으면 1
        log.info("Result for nickname {}: {}", nickname, result);

        Map<String, Integer> response = new HashMap<>();
        response.put("result", result); // 결과를 map에 담아서 응답
        return ResponseEntity.ok(response); // 200 OK와 함께 JSON 응답 반환
    }

}
