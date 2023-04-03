package org.javpm.mybank.application.queries;

import org.javpm.mybank.domain.model.Wallet;
import org.javpm.mybank.domain.repositories.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class FindWalletQueryHandler implements QueryHandler<Integer, Mono<Wallet>> {

  private final WalletRepository walletRepository;

  @Override
  public Mono<Wallet> execute(Integer walletId) {
    return walletRepository.findById(walletId);
  }
}
