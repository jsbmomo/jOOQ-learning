package com.spring.jooq.domain.member;

import com.spring.jooq.domain.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.spring.jooq.tables.Member.MEMBER;

@RequiredArgsConstructor
@Repository
public class MemberRepository {

  private final DSLContext dsl;

  public List<Member> findAllMember() {
    return dsl
        .select(MEMBER.USER_ID, MEMBER.NAME, MEMBER.AGE, MEMBER.EMAIL, MEMBER.ADDRESS, MEMBER.REG_DT)
          .from(MEMBER)
          .orderBy(MEMBER.USER_ID.desc())
        .fetch(m -> new Member(
            m.get(MEMBER.USER_ID),
            m.get(MEMBER.NAME),
            m.get(MEMBER.AGE),
            m.get(MEMBER.ADDRESS),
            m.get(MEMBER.EMAIL),
            m.get(MEMBER.REG_DT)
        ));
  }

  public Member findMemberById(Long userId) {
    return dsl
        .select()
          .from(MEMBER)
          .where(MEMBER.USER_ID.eq(userId))
        .fetchOneInto(Member.class);
  }

  public List<MemberDto> findMembersByLocationAndAge(String location, int age) {
    return dsl
        .select(MEMBER.USER_ID, MEMBER.NAME, MEMBER.EMAIL, MEMBER.ADDRESS, MEMBER.REG_DT)
          .from(MEMBER)
          .where(MEMBER.ADDRESS.contains(location))
          .and(MEMBER.AGE.lessThan(age))
        .fetchInto(MemberDto.class);
  }

}
