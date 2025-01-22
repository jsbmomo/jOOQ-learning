package com.spring.jooq.purchase;

import com.spring.jooq.domain.purchase.Purchase;
import com.spring.jooq.domain.purchase.PurchaseRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PurchaseRepositoryTest {

  @Autowired
  PurchaseRepository purchaseRepository;

  @DisplayName("[Purchase] 특정_판매이력_조회")
  @Test
  void find_purchase_id() {
    // given

    // when
    Optional<Purchase> purchase = purchaseRepository.findByPurchaseId(3L);

    // then
    assertTrue(purchase.isPresent(), "Purchase 객체가 존재합니다.");
    assertThat(purchase.get().place()).contains("백화점");
  }

  @DisplayName("[Purchase] 구매자_목록_조회")
  @Test
  void find_purchase_member() {
    // given

    // when

    // then
  }

  @DisplayName("[Purchase] 판매량_상위_3곳_조회")
  @Test
  void find_purchase_product() {
    // given

    // when

    // then
  }

  @DisplayName("[Purchase] 판매량_상세내역_조회")
  @Test
  void find_purchase_detail() {
    // given

    // when

    // then
  }

}
