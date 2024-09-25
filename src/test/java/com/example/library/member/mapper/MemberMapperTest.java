package com.example.library.member.mapper;

import com.example.library.member.domain.Auth;
import com.example.library.member.domain.MemberVO;
import com.example.library.member.domain.Sex;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@MybatisTest
@Slf4j
class MemberMapperTest {

    @Autowired
    private MemberMapper mapper;

    @Test
    void mapperConnectTest() throws Exception {
        log.info("mapper={}", mapper.toString());
    }

    @Test
    @DisplayName("mapper 연결 확인")
    void mapperIdTest() throws Exception {
        //given
        MemberVO member = mapper.read("admin@gmail.com");
        //when, then
        log.info("member={}", member);
        Assertions.assertThat(member.getPassword()).isEqualTo("admin");
    }
}