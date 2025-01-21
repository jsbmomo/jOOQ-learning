package com.spring.jooq.domain.member.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberDto {

  private Long userId;
  private String name;
  private String email;
  private String address;
  private LocalDateTime regDt;

}
