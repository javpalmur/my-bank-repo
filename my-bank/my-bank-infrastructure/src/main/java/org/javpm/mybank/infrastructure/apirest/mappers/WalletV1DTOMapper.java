package org.javpm.mybank.infrastructure.apirest.mappers;

import org.javpm.mybank.application.commands.CreateDepositCommand;
import org.javpm.mybank.domain.model.Wallet;
import org.javpm.mybank.infrastructure.apirest.model.DepositRequestV1DTO;
import org.javpm.mybank.infrastructure.apirest.model.WalletRequestV1DTO;
import org.javpm.mybank.application.commands.CreateWalletCommand;
import org.javpm.mybank.infrastructure.apirest.model.WalletV1DTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface WalletV1DTOMapper {

  CreateWalletCommand asSaveWalletCommand(WalletRequestV1DTO src);

  @Mapping(target = "targetWalletId", source = "walletId")
  CreateDepositCommand asCreateDepositCommand(DepositRequestV1DTO src, Integer walletId);

  WalletV1DTO asWalletV1DTO(Wallet wallet);
}
