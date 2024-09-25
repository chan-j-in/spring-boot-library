package com.example.library.member.service;

import com.example.library.member.domain.MemberVO;
import com.example.library.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {

    private final MemberMapper mapper;

    @Override
    public MemberVO login(String email, String password) {

        log.info("========== member login service");
        log.info("Email: {}", email);
        log.info("Password: {}", password == null ? "null" : password);
        MemberVO readMember = mapper.read(email);
        if (readMember != null) {
            if (readMember.getPassword().equals(password)) {
                return readMember;
            }
        }
        return null;
    }

    @Override
    public MemberVO get(String param) {

        log.info("========== member get service");

        MemberVO readMember = mapper.read(param);
        if (readMember!=null) {
            return readMember;
        }
        return null;
    }
}
