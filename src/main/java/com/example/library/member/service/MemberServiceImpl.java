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
        MemberVO readMember = mapper.readByEmail(email);
        if (readMember != null) {
            if (readMember.getPassword().equals(password)) {
                return readMember;
            }
        }
        return null;
    }

    @Override
    public MemberVO get(String param, boolean isEmail) {

        log.info("========== member get service");
        MemberVO readMember;
        if (isEmail) {
            readMember = mapper.readByEmail(param);
        } else {
            readMember = mapper.readByNickname(param);
        }
        log.info("Read Member: {}", readMember);
        return readMember;
    }

    @Override
    public boolean join(MemberVO member) {

        log.info("========== member join service");
        boolean joinResult = mapper.insert(member) == 1;
        return joinResult;
    }

    @Override
    public boolean modify(MemberVO member) {

        log.info("========== member modify service");
        boolean updateResult = mapper.update(member) == 1;
        return updateResult;
    }
}
