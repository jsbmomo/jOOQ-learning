package com.spring.jooq.domain.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDto {

  private Long prodId;
  private String prodName;
  private Integer prodPrice;

}
