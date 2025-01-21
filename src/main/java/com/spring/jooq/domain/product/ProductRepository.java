package com.spring.jooq.domain.product;

import com.spring.jooq.domain.product.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.spring.jooq.tables.Product.*;

@RequiredArgsConstructor
@Repository
public class ProductRepository {

  private final DSLContext dsl;

  public List<Product> findAllProduct() {
    return dsl.select()
        .from(PRODUCT)
        .fetchInto(Product.class);
  }

  public Product findByProductId(Long id) {
    return dsl.select()
        .from(PRODUCT)
        .where(PRODUCT.PROD_ID.eq(id))
        .fetchOneInto(Product.class);
  }

  @Transactional
  public int createProductItems(List<Product> products) {
    return dsl.insertInto(PRODUCT, PRODUCT.PROD_NAME, PRODUCT.PROD_PRICE)
        .valuesOfRows(products
            .stream()
            .map(p -> DSL.row(p.prodName(), p.prodPrice()))
            .toList()
        ).execute();
  }

  public ProductDto createProduct(Product product) {
    return dsl.insertInto(PRODUCT)
        .set(PRODUCT.PROD_NAME, product.prodName())
        .set(PRODUCT.PROD_PRICE, product.prodPrice())
        .returning()
        .fetchOne(p -> new ProductDto(p.getProdId(), p.getProdName(), p.getProdPrice()));
  }

  public void updateProduct(Product product) {
    dsl.update(PRODUCT)
        .set(PRODUCT.PROD_NAME, product.prodName())
        .set(PRODUCT.PROD_PRICE, product.prodPrice())
        .where(PRODUCT.PROD_ID.eq(product.prodId()))
        .execute();
  }

  public void deleteProduct(Long id) {
    dsl.deleteFrom(PRODUCT)
        .where(PRODUCT.PROD_ID.eq(id))
        .execute();
  }

}
