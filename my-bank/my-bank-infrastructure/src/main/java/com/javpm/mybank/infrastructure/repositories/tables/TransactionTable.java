package com.javpm.mybank.infrastructure.repositories.tables;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table(name = "transactions")
public class TransactionTable {

  @Id
  Integer id;

  Integer targetWalletId;

  Integer originWalletId;

  Long amount;

  LocalDateTime createdAt;
}
