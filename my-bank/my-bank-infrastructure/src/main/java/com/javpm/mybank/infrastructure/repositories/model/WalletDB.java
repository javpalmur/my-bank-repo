package com.javpm.mybank.infrastructure.repositories.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class WalletDB {

  @Id
  Integer id;
}
