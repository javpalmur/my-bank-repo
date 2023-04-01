package com.javpm.mybank.infrastructure.apirest.mappers;

import com.javpm.mybank.domain.User;
import com.javpm.mybank.domain.Wallet;
import com.javpm.mybank.infraastructure.apirest.model.UserV1DTO;
import com.javpm.mybank.infraastructure.apirest.model.WalletRequestV1DTO;
import com.javpm.mybank.application.commands.SaveWalletCommand;
import com.javpm.mybank.infraastructure.apirest.model.WalletV1DTO;
import org.mapstruct.Mapper;

@Mapper
public interface WalletV1DTOMapper {

  SaveWalletCommand asSaveWalletCommand(WalletRequestV1DTO src);

  WalletV1DTO asWalletV1DTO(Wallet wallet);
}
