package com.javpm.mybank.infrastructure.repositories.tables;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table(name = "users")
public class UserTable {

  @Id
  Integer id;

  String name;

  String lastName;

  String email;

  String password;
}
