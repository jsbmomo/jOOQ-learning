package com.spring.jooq.member;

import com.spring.jooq.domain.member.Member;
import com.spring.jooq.domain.member.MemberRepository;

import com.spring.jooq.domain.member.dto.MemberDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MemberRepositoryTest {

  @Autowired
  MemberRepository memberRepository;

  @DisplayName("[Member] 모든_Member_조회")
  @Test
  void find_all_member() {
    // given

    // when
    List<Member> allMember = memberRepository.findAllMember();

    // then
    assertEquals(5, allMember.size());
  }

  @DisplayName("[Member] 특정_Member_조회")
  @Test
  void find_member_by_id() {
    // given

    // when
    Member member = memberRepository.findMemberById(3L);

    // then
    assertEquals("Mr.Kim", member.name());
    assertEquals(21, member.age());
  }

  @DisplayName("[Member] 기준에_부합한_Member_조회")
  @Test
  void find_members_by_location_and_age() {
    // given

    // when
    List<MemberDto> member = memberRepository.findMembersByLocationAndAge("울산", 31);

    // then
    assertEquals(2, member.size());
    assertEquals("김규하", member.get(0).getName());
  }
}
