package com.javpm.mybank.infrastructure.apirest.mappers;

import com.javpm.mybank.application.commands.CreateDepositCommand;
import com.javpm.mybank.domain.model.Wallet;
import com.javpm.mybank.infraastructure.apirest.model.DepositRequestV1DTO;
import com.javpm.mybank.infraastructure.apirest.model.WalletRequestV1DTO;
import com.javpm.mybank.application.commands.CreateWalletCommand;
import com.javpm.mybank.infraastructure.apirest.model.WalletV1DTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface WalletV1DTOMapper {

  CreateWalletCommand asSaveWalletCommand(WalletRequestV1DTO src);

  @Mapping(target = "targetWalletId", source = "walletId")
  CreateDepositCommand asCreateDepositCommand(DepositRequestV1DTO src, Integer walletId);

  WalletV1DTO asWalletV1DTO(Wallet wallet);
}
