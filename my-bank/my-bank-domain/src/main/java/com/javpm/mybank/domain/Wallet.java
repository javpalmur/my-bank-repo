package com.javpm.mybank.domain;

import lombok.Data;

@Data
public class Wallet {

  Integer id;

  String name;

  String currency;

  String amount;
}
