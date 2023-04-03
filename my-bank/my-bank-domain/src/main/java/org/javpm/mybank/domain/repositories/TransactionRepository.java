package org.javpm.mybank.domain.repositories;

import org.javpm.mybank.domain.model.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionRepository {

  Mono<Transaction> save(Transaction transaction);

  Flux<Transaction> findByWalletId(Integer walletId);
}
