package org.javpm.mybank.application.mappers;

import org.javpm.mybank.application.commands.CreateWalletCommand;
import org.javpm.mybank.domain.model.Wallet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CreateWalletCommandMapper {

  @Mapping(target = "balance", constant = "0L")
  Wallet asWallet(CreateWalletCommand command);
}
