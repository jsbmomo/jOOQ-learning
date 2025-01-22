package com.spring.jooq.domain.purchase;

public record Purchase(Long id, Long memberId, Long prodId) {

  public static Purchase create(Long id, Long memberId, Long prodId) {
    return new Purchase(id, memberId, prodId);
  }

}
