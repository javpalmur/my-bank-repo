package org.javpm.mybank.application.commands;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateWalletCommand implements Command {
  Integer userId;
  String nickname;
}
