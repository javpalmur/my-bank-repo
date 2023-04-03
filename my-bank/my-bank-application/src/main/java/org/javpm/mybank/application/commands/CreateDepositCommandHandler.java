package org.javpm.mybank.application.commands;

import org.javpm.mybank.application.mappers.CreateDepositCommandMapper;
import org.javpm.mybank.application.services.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class CreateDepositCommandHandler implements CommandHandler<CreateDepositCommand, Void> {

  private final CreateDepositCommandMapper commandMapper;

  private final TransactionService transactionService;

  @Override
  public Mono<Void> execute(CreateDepositCommand command) {
    return Mono.just(command)
        .map(this.commandMapper::asTransaction)
        .flatMap(transactionService::validateAndSaveTransaction);
  }
}
