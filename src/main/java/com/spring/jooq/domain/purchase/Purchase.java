package com.spring.jooq.domain.purchase;

public record Purchase(Long id, Long memberId, Long prodId, String place) {

  public static Purchase create(Long id, Long memberId, Long prodId, String place) {
    return new Purchase(id, memberId, prodId, place);
  }

}
