package com.javpm.mybank.application.commands;

import com.javpm.mybank.application.mappers.SaveWalletCommandMapper;
import com.javpm.mybank.domain.Wallet;
import com.javpm.mybank.domain.repositories.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class SaveWalletCommandHandler implements SaveCommandHandler<SaveWalletCommand, Wallet>{

  private final SaveWalletCommandMapper commandMapper;

  private final WalletRepository walletRepository;

  @Override
  public Mono<Wallet> execute(SaveWalletCommand command) {
    return Mono.just(command)
        .map(commandMapper::asWallet)
        .flatMap(walletRepository::save);
  }}
