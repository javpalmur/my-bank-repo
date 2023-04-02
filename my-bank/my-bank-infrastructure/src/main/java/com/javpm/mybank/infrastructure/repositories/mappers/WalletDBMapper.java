package com.javpm.mybank.infrastructure.repositories.mappers;

import com.javpm.mybank.domain.model.Wallet;
import com.javpm.mybank.infrastructure.repositories.model.WalletDB;
import org.mapstruct.Mapper;

@Mapper
public interface WalletDBMapper {

  Wallet asWallet(WalletDB walletDB);

  WalletDB asWalletDB(Wallet wallet);
}
