package com.javpm.mybank.application.mappers;

import com.javpm.mybank.application.commands.SaveWalletCommand;
import com.javpm.mybank.domain.Wallet;
import org.mapstruct.Mapper;

@Mapper
public interface SaveWalletCommandMapper {

  Wallet asWallet(SaveWalletCommand command);
}
