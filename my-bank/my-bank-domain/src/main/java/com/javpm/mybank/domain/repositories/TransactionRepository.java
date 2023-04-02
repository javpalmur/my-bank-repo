package com.javpm.mybank.domain.repositories;

import com.javpm.mybank.domain.model.Transaction;
import reactor.core.publisher.Mono;

public interface TransactionRepository {

  Mono<Transaction> save(Transaction transaction);
}
