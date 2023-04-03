package org.javpm.mybank.infrastructure.repositories.mappers;

import org.javpm.mybank.domain.model.Transaction;
import org.javpm.mybank.infrastructure.repositories.tables.TransactionTable;
import org.mapstruct.Mapper;

@Mapper
public interface TransactionTableMapper {

  Transaction asTransaction(TransactionTable transactionTable);

  TransactionTable asTransactionTable(Transaction transaction);
}
