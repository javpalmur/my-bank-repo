package org.javpm.mybank.infrastructure.repositories;

import org.javpm.mybank.domain.model.Transaction;
import org.javpm.mybank.domain.repositories.TransactionRepository;
import org.javpm.mybank.infrastructure.repositories.mappers.TransactionTableMapper;
import org.javpm.mybank.infrastructure.repositories.tables.TransactionTable;
import lombok.AllArgsConstructor;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class TransactionR2DBCRepositoryImpl implements TransactionRepository {

  private TransactionH2Repository repository;

  private TransactionTableMapper transactionTableMapper;

  @Override
  public Mono<Transaction> save(Transaction transaction) {
    return Mono.just(transaction)
        .map(transactionTableMapper::asTransactionTable)
        .flatMap(this.repository::save)
        .map(transactionTableMapper::asTransaction);
  }

  @Override
  public Flux<Transaction> findByWalletId(Integer walletId) {
    return this.repository.findByOriginWalletIdOrTargetWalletId(walletId, walletId)
        .map(transactionTableMapper::asTransaction);
  }

  @Repository
  public interface TransactionH2Repository extends R2dbcRepository<TransactionTable, Integer> {

    Flux<TransactionTable> findByOriginWalletIdOrTargetWalletId(Integer originWalletId, Integer targetWalletId);
  }
}
