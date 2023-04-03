package com.javpm.mybank.infrastructure.repositories;

import com.javpm.mybank.domain.exceptions.NotFoundException;
import com.javpm.mybank.domain.model.Wallet;
import com.javpm.mybank.domain.repositories.WalletRepository;
import com.javpm.mybank.infrastructure.repositories.mappers.WalletTableMapper;
import com.javpm.mybank.infrastructure.repositories.tables.WalletTable;
import lombok.AllArgsConstructor;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class WalletR2DBCRepositoryImpl implements WalletRepository {

  private WalletH2Repository repository;

  private WalletTableMapper walletTableMapper;

  @Override
  public Mono<Wallet> save(Wallet wallet) {
    return Mono.just(wallet)
        .map(walletTableMapper::asWalletDB)
        .flatMap(this.repository::save)
        .map(walletTableMapper::asWallet);
  }

  @Override
  public Mono<Wallet> findById(Integer walletId) {
    return Mono.just(walletId)
        .flatMap(this.repository::findById)
        .switchIfEmpty(Mono.defer(() -> Mono.error(new NotFoundException(String.format("Wallet with id %s not found", walletId)))))
        .map(walletTableMapper::asWallet);
  }

  @Repository
  public interface WalletH2Repository extends R2dbcRepository<WalletTable, Integer> {
  }
}
