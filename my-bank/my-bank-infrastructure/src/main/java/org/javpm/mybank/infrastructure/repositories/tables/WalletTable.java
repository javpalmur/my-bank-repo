package org.javpm.mybank.infrastructure.repositories.tables;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table(name = "wallets")
public class WalletTable {

  @Id
  Integer id;

  Integer userId;

  String nickname;

  Long balance;
}
