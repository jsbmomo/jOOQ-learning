package com.spring.jooq.domain.purchase;

import com.spring.jooq.domain.purchase.dto.PurchaseDetailDto;
import com.spring.jooq.domain.purchase.dto.PurchaseMemberDto;
import com.spring.jooq.domain.purchase.dto.PurchaseProductDto;
import com.spring.jooq.tables.Member;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.spring.jooq.Tables.MEMBER;
import static com.spring.jooq.Tables.PURCHASE;
import static com.spring.jooq.tables.Product.PRODUCT;
import static org.jooq.Records.mapping;
import static org.jooq.impl.DSL.sum;

@RequiredArgsConstructor
@Repository
public class PurchaseRepository {

  private final DSLContext dsl;

  public Optional<Purchase> findByPurchaseId(Long id) {
    return dsl
          .select(PURCHASE.HISTORY_ID, PURCHASE.USER_ID, PURCHASE.PROD_ID, PURCHASE.PLACE)
          .from(PURCHASE)
          .where(PURCHASE.HISTORY_ID.eq(id))
        .fetchOptional()
        .map(mapping(Purchase::create));
  }

  public List<PurchaseMemberDto> findByPurchaseWithMember() {
    return dsl
          .select(PURCHASE, MEMBER)
          .from(PURCHASE)
          .join(MEMBER)
          .on(PURCHASE.USER_ID.eq(MEMBER.USER_ID))
        .fetchInto(PurchaseMemberDto.class);
  }

  public List<PurchaseProductDto> findByPurchaseWithProduct() {
    return dsl
          .select(PURCHASE.PLACE, sum(PRODUCT.PROD_PRICE))
          .from(PURCHASE)
          .leftJoin(PRODUCT)
          .on(PURCHASE.PROD_ID.eq(PRODUCT.PROD_ID))
          .orderBy(PRODUCT.PROD_PRICE)
          .limit(3)
        .fetchInto(PurchaseProductDto.class);
  }

  public List<PurchaseDetailDto> findByPurchaseDetail() {
    return dsl
          .select(
              PURCHASE.HISTORY_ID,
              PURCHASE.PLACE,
              MEMBER.USER_ID,
              MEMBER.NAME,
              MEMBER.EMAIL,
              MEMBER.ADDRESS,
              PRODUCT.PROD_ID,
              PRODUCT.PROD_NAME,
              PRODUCT.PROD_PRICE)
          .from(PURCHASE)
          .leftJoin(MEMBER)
            .on(PURCHASE.USER_ID.eq(MEMBER.USER_ID))
          .leftJoin(PRODUCT)
            .on(PURCHASE.PROD_ID.eq(PRODUCT.PROD_ID))
          .where(Member.MEMBER.ADDRESS.contains("울산"))
        .fetchInto(PurchaseDetailDto.class);
  }

}
