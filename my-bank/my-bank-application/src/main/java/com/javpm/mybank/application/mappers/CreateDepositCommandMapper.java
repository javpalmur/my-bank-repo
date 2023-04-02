package com.javpm.mybank.application.mappers;

import com.javpm.mybank.application.commands.CreateDepositCommand;
import com.javpm.mybank.domain.model.Transaction;
import org.mapstruct.Mapper;

@Mapper
public interface CreateDepositCommandMapper {

  Transaction asTransaction(CreateDepositCommand command);
}
