package com.javpm.mybank.domain;

import lombok.Data;

@Data
public class User {

  Integer id;

  String name;

  String lastName;

  String email;

  String password;
}
