package com.example.library.member.mapper;

import com.example.library.member.domain.MemberVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberMapper {
        public MemberVO read(String email);
}
