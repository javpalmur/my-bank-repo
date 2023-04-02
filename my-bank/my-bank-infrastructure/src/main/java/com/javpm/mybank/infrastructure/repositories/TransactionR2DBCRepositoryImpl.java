package com.javpm.mybank.infrastructure.repositories;

import com.javpm.mybank.domain.model.Transaction;
import com.javpm.mybank.domain.repositories.TransactionRepository;
import com.javpm.mybank.infrastructure.repositories.mappers.TransactionDBMapper;
import com.javpm.mybank.infrastructure.repositories.model.TransactionDB;
import lombok.AllArgsConstructor;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class TransactionR2DBCRepositoryImpl implements TransactionRepository {

  private TransactionH2Repository repository;

  private TransactionDBMapper transactionDBMapper;

  @Override
  public Mono<Transaction> save(Transaction transaction) {
    return Mono.just(transaction)
        .map(transactionDBMapper::asTransactionDB)
        .flatMap(this.repository::save)
        .map(transactionDBMapper::asTransaction);
  }

  @Repository
  public interface TransactionH2Repository extends R2dbcRepository<TransactionDB, Integer> {
  }
}
