package org.javpm.mybank.domain.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Transaction {

  Integer id;

  Integer targetWalletId;

  Integer originWalletId;

  Long amount;

  LocalDateTime createdAt = LocalDateTime.now();
}
