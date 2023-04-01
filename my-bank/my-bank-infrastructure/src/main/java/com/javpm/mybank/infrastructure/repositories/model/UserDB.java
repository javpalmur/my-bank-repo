package com.javpm.mybank.infrastructure.repositories.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class UserDB {

  @Id
  Integer id;

  String name;

  String lastName;

  String email;

  String password;
}
