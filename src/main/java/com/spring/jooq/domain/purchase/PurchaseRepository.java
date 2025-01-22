package com.spring.jooq.domain.purchase;

import com.spring.jooq.domain.purchase.dto.PurchaseMemberDto;
import com.spring.jooq.tables.Member;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.spring.jooq.Tables.MEMBER;
import static com.spring.jooq.Tables.PURCHASE;
import static org.jooq.Records.mapping;

@RequiredArgsConstructor
@Repository
public class PurchaseRepository {

  private final DSLContext dsl;

  public Optional<Purchase> findByPurchaseId(Long id) {
    return dsl
          .select(PURCHASE.HISTORY_ID, PURCHASE.USER_ID, PURCHASE.PROD_ID)
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

}
