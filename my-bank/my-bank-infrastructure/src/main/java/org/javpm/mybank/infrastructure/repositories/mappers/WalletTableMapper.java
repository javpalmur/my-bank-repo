package org.javpm.mybank.infrastructure.repositories.mappers;

import org.javpm.mybank.domain.model.Wallet;
import org.javpm.mybank.infrastructure.repositories.tables.WalletTable;
import org.mapstruct.Mapper;

@Mapper
public interface WalletTableMapper {

  Wallet asWallet(WalletTable walletTable);

  WalletTable asWalletDB(Wallet wallet);
}
