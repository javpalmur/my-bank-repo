package org.javpm.mybank.application.mappers;

import org.javpm.mybank.application.commands.CreateDepositCommand;
import org.javpm.mybank.domain.model.Transaction;
import org.mapstruct.Mapper;

@Mapper
public interface CreateDepositCommandMapper {

  Transaction asTransaction(CreateDepositCommand command);
}
