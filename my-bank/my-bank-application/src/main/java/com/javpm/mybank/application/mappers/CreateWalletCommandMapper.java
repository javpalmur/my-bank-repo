package com.javpm.mybank.application.mappers;

import com.javpm.mybank.application.commands.CreateWalletCommand;
import com.javpm.mybank.domain.model.Wallet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CreateWalletCommandMapper {

  @Mapping(target = "balance", constant = "0L")
  Wallet asWallet(CreateWalletCommand command);
}
