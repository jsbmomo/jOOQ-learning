package com.spring.jooq.domain.purchase.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseDetailDto {

  private Long id;
  private String place;

  private Long userId;
  private String name;
  private String email;
  private String address;

  private Long prodId;
  private String prodName;
  private int prodPrice;

}
