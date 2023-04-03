package org.javpm.mybank.application.commands;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RegisterUserCommand implements Command {

  String name;

  String lastName;

  String email;

  String password;
}
