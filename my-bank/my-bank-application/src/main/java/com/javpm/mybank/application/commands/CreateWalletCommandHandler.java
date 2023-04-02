package com.javpm.mybank.application.commands;

import com.javpm.mybank.application.mappers.CreateWalletCommandMapper;
import com.javpm.mybank.domain.model.Wallet;
import com.javpm.mybank.domain.repositories.UserRepository;
import com.javpm.mybank.domain.repositories.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class CreateWalletCommandHandler implements CommandHandler<CreateWalletCommand, Wallet> {

  private final CreateWalletCommandMapper commandMapper;

  private final WalletRepository walletRepository;

  private final UserRepository userRepository;

  @Override
  public Mono<Wallet> execute(CreateWalletCommand command) {
    return Mono.just(command)
        .flatMap(createWalletCommand -> userRepository.findById(command.getUserId())
        .map(user -> commandMapper.asWallet(command))
        .flatMap(walletRepository::save));
  }}
