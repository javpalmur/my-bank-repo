package org.javpm.mybank.application.queries;

import org.javpm.mybank.domain.repositories.TransactionRepository;
import org.javpm.mybank.domain.repositories.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.function.TupleUtils;

@Component
@AllArgsConstructor
public class FindWalletExtendedQueryHandler implements QueryHandler<Integer, Mono<WalletExtendedVO>> {

  private final WalletRepository walletRepository;

  private final TransactionRepository transactionRepository;

  @Override
  public Mono<WalletExtendedVO> execute(Integer walletId)
  {
    return walletRepository.findById(walletId)
        .zipWith(this.transactionRepository.findByWalletId(walletId).collectList())
        .map(TupleUtils.function((walletFound, transactionList) -> WalletExtendedVO.builder()
            .wallet(walletFound)
            .transactions(transactionList)
            .build()));
  }
}
