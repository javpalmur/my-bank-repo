package com.javpm.mybank.infrastructure.repositories.mappers;

import com.javpm.mybank.domain.model.Transaction;
import com.javpm.mybank.infrastructure.repositories.model.TransactionDB;
import org.mapstruct.Mapper;

@Mapper
public interface TransactionDBMapper {

  Transaction asTransaction(TransactionDB transactionDB);

  TransactionDB asTransactionDB(Transaction transaction);
}
