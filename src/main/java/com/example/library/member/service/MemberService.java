package com.example.library.member.service;

import com.example.library.member.domain.MemberVO;

public interface MemberService {
    public MemberVO login(String email, String password);
    public MemberVO get(String param);
}
