package com.spring.jooq.domain.member;

import java.time.LocalDateTime;

public record Member(Long userId, String name, int age, String address, String email, LocalDateTime regDt) {
}
