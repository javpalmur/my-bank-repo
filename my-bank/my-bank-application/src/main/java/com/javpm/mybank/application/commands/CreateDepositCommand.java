package com.javpm.mybank.application.commands;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateDepositCommand implements Command {

  Integer targetWalletId;

  Long amount;
}
