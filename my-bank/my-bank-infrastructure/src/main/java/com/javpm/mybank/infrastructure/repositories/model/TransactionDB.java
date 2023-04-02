package com.javpm.mybank.infrastructure.repositories.model;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class TransactionDB {

  @Id
  Integer id;

  Integer targetWalletId;

  Integer originWalletId;

  Long amount;

  LocalDateTime createdAt;
}
