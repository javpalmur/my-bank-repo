package com.javpm.mybank.infrastructure.repositories.mappers;

import com.javpm.mybank.domain.model.Wallet;
import com.javpm.mybank.infrastructure.repositories.tables.WalletTable;
import org.mapstruct.Mapper;

@Mapper
public interface WalletTableMapper {

  Wallet asWallet(WalletTable walletTable);

  WalletTable asWalletDB(Wallet wallet);
}
