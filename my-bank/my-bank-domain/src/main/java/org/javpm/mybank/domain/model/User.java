package org.javpm.mybank.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
public class User {

  Integer id;

  String name;

  String lastName;

  String email;

  String password;
}
