package com.javpm.mybank.application.commands;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class SaveUserCommand implements Command {

  String name;

  String lastName;

  String email;

  String password;

}
