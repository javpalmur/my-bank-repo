package org.javpm.mybank.domain.model;

import lombok.Data;

@Data
public class Wallet {

  Integer id;

  String nickname;

  Integer userId;

  Long balance;
}
