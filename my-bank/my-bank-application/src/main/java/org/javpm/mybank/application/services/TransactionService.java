package org.javpm.mybank.application.services;

import org.javpm.mybank.domain.model.Transaction;
import org.javpm.mybank.domain.repositories.TransactionRepository;
import org.javpm.mybank.domain.repositories.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class TransactionService {

  private final WalletRepository walletRepository;

  private final TransactionRepository transactionRepository;

  public Mono<Void> validateAndSaveTransaction(final Transaction transaction) {
    return walletRepository.findById(transaction.getTargetWalletId())
        .flatMap(wallet -> {
          if (transaction.getOriginWalletId() != null) {
            return walletRepository.findById(transaction.getOriginWalletId());
          } else {
            return Mono.just(wallet);
          }
        })
        .flatMap(wallet -> transactionRepository.save(transaction))
        .then();
  }
}
