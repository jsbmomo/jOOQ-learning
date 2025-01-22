package com.spring.jooq.domain.purchase.dto;

import com.spring.jooq.tables.Purchase;
import com.spring.jooq.tables.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseProductDto {

  private String place;
  private int sales;

}
