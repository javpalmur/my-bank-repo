package com.javpm.mybank.infrastructure.repositories.mappers;

import com.javpm.mybank.domain.User;
import com.javpm.mybank.domain.Wallet;
import com.javpm.mybank.infrastructure.repositories.model.UserDB;
import com.javpm.mybank.infrastructure.repositories.model.WalletDB;
import org.mapstruct.Mapper;

@Mapper
public interface WalletDBMapper {

  Wallet asWallet(WalletDB walletDB);

  WalletDB asWalletDB(Wallet walletDB);
}
