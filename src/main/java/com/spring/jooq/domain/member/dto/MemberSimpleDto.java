package com.spring.jooq.domain.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberSimpleDto {

  private Long userId;
  private String name;
  private String email;

}
