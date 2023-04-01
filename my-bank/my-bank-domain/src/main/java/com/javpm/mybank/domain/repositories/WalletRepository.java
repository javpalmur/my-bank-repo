package com.javpm.mybank.domain.repositories;

import com.javpm.mybank.domain.Wallet;
import reactor.core.publisher.Mono;


public interface WalletRepository {

  Mono<Wallet> save(Wallet wallet);

  Mono<Wallet> findById(Integer walletId);
}
