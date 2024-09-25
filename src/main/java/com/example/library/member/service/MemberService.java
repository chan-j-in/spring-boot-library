package com.example.library.member.service;

import com.example.library.member.domain.MemberVO;

public interface MemberService {
    public MemberVO login(String email, String password);
    public MemberVO get(String param, boolean isEmail);
    public boolean join(MemberVO member);
    public boolean modify(MemberVO member);
}
