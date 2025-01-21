package com.spring.jooq.product;

import com.spring.jooq.domain.product.Product;
import com.spring.jooq.domain.product.ProductRepository;
import com.spring.jooq.domain.product.dto.ProductDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductRepositoryTest {

  @Autowired
  ProductRepository productRepository;

  @DisplayName("[Product] 사무용품_데이터_다중추가")
  @Test
  void create_product_items() {
    // given
    List<Product> items = new ArrayList<>();
    items.add(new Product(null, "거치대", 20_000));
    items.add(new Product(null, "모니터암", 100_000));
    items.add(new Product(null, "다이어리", 8000));

    // when
    int productItems = productRepository.createProductItems(items);
    Product product = productRepository.findByProductId(7L);

    // then
    assertThat(productItems).isEqualTo(3);
    assertThat(product).isNotNull();
    assertThat(product.prodId()).isEqualTo(7L);
    assertThat(product.prodName()).isEqualTo("모니터암");
  }

  @DisplayName("[Product] 사무용품_데이터_추가")
  @Test
  void create_product() {
    // given
    Product diary = new Product(null, "다이어리", 9000);

    // when
    ProductDto product = productRepository.createProduct(diary);

    // then
    assertThat(product).isNotNull();
    assertThat(product.getProdId()).isEqualTo(6L);
    assertThat(product.getProdName()).isEqualTo("다이어리");
  }

  @DisplayName("[Product] 사무용품_데이터_수정")
  @Test
  void update_product() {
    // given
    Product updateProduct = new Product(3L, "무선 키보드", 17000);

    // when
    productRepository.updateProduct(updateProduct);

    // then
    Product product = productRepository.findByProductId(3L);

    assertThat(product).isNotNull();
    assertThat(product.prodName()).isEqualTo("무선 키보드");
    assertThat(product.prodPrice()).isEqualTo(17000);
  }

  @DisplayName("[Product] 사무용품_데이터_삭제")
  @Test
  void delete_product() {
    // given

    // when
    productRepository.deleteProduct(3L);

    // then
    List<Product> product = productRepository.findAllProduct();

    assertThat(product.stream().findFirst()).isPresent();
  }

}
