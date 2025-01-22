package com.spring.jooq.domain.purchase.dto;

import com.spring.jooq.tables.Purchase;
import com.spring.jooq.tables.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseMemberDto {

  private Purchase purchase;
  private Member member;

}
