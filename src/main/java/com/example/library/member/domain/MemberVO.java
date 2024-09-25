package com.example.library.member.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class MemberVO {

    private String email; // 회원 아이디
    private String password; //비밀번호
    private Auth role; // 회원 권한 (admin, member)
    private String name;
    private String nickname;
    private Sex mfCode; //성별 (men, female)
    private String cellNo;
    private Date joinDate;
    private Date updateDate;
}
