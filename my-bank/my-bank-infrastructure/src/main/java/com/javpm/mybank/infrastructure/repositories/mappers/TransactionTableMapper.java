package com.javpm.mybank.infrastructure.repositories.mappers;

import com.javpm.mybank.domain.model.Transaction;
import com.javpm.mybank.infrastructure.repositories.tables.TransactionTable;
import org.mapstruct.Mapper;

@Mapper
public interface TransactionTableMapper {

  Transaction asTransaction(TransactionTable transactionTable);

  TransactionTable asTransactionTable(Transaction transaction);
}
