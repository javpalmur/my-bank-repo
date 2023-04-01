package com.javpm.mybank.infrastructure.repositories;

import com.javpm.mybank.domain.Wallet;
import com.javpm.mybank.domain.repositories.WalletRepository;
import com.javpm.mybank.infrastructure.repositories.model.WalletDB;
import lombok.AllArgsConstructor;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class WalletR2DBCRepositoryImpl implements WalletRepository {

  private WalletH2Repository repository;

  @Override
  public Mono<Wallet> save(Wallet wallet) {
    return null;
  }

  @Override
  public Mono<Wallet> findById(Integer walletId) {
    return null;
  }

  @Repository
  public interface WalletH2Repository extends R2dbcRepository<WalletDB, Integer> {
  }
}
