package com.example.library.member.mapper;

import com.example.library.member.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberMapper {
        public MemberVO readByEmail(String email);

        public MemberVO readByNickname(String nickname);

        public int insert(MemberVO member);

        public int update(MemberVO member);
}
