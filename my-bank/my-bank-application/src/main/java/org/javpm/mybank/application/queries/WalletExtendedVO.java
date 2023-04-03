package org.javpm.mybank.application.queries;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import org.javpm.mybank.domain.model.Transaction;
import org.javpm.mybank.domain.model.Wallet;

@Builder
@Data
public class WalletExtendedVO {

  Wallet wallet;

  List<Transaction> transactions;
}
