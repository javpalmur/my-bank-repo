package org.javpm.mybank.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.javpm.mybank.application.queries.WalletExtendedVO;
import org.javpm.mybank.domain.model.Transaction;
import org.javpm.mybank.domain.model.User;
import org.javpm.mybank.domain.model.Wallet;
import org.javpm.mybank.domain.repositories.TransactionRepository;
import org.javpm.mybank.domain.repositories.UserRepository;
import org.javpm.mybank.domain.repositories.WalletRepository;
import org.javpm.mybank.infrastructure.apirest.model.DepositRequestV1DTO;
import org.javpm.mybank.infrastructure.apirest.model.WalletExtendedV1DTO;
import org.javpm.mybank.infrastructure.apirest.model.WalletRequestV1DTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@AutoConfigureWebTestClient(timeout = "300000")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class WalletV1RestIT {

  private static final String BASE_PATH = "/v1/wallets";

  private static final String WALLET_NICKNAME = "WALLET_NICKNAME";

  @Autowired
  private WebTestClient webClient;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private WalletRepository walletRepository;

  @Autowired
  private TransactionRepository transactionRepository;

  @Test
  void createWallet() {
    // Arrange
    final User user = new User();
    user.setName("USER_NAME");
    user.setEmail("email@email.com");
    user.setLastName("LAST_NAME");
    user.setPassword("PASSWORD");
    final User savedUser = userRepository.save(user).block();
    final WalletRequestV1DTO walletRequestV1DTO = new WalletRequestV1DTO()
        .userId(savedUser.getId())
        .nickname(WALLET_NICKNAME)
        .userId(savedUser.getId());

    // Act
    final WebTestClient.ResponseSpec response = this.webClient.post()
        .uri(BASE_PATH)
        .body(Mono.just(walletRequestV1DTO), WalletRequestV1DTO.class)
        .accept(MediaType.APPLICATION_JSON)
        .exchange();

    // Assert
    response.expectStatus().isCreated();
  }

  @Test
  void findWalletExtended() {
    // Arrange
    final User user = new User();
    user.setName("USER_NAME");
    user.setEmail("email@email.com");
    user.setLastName("LAST_NAME");
    user.setPassword("PASSWORD");
    final User savedUser = userRepository.save(user).block();

    final Wallet wallet = new Wallet();
    wallet.setBalance(0L);
    wallet.setNickname("WALLET_NICKNAME");
    wallet.setUserId(savedUser.getId());
    final Wallet savedWallet = walletRepository.save(wallet).block();

    final Transaction transaction = new Transaction();
    transaction.setAmount(20L);
    transaction.setTargetWalletId(savedWallet.getId());
    transaction.setCreatedAt(LocalDateTime.now());
    transactionRepository.save(transaction).block();
    // Act
    final WebTestClient.ResponseSpec response = this.webClient.get()
        .uri(BASE_PATH + "/" + savedWallet.getId())
        .accept(MediaType.APPLICATION_JSON)
        .exchange();

    // Assert
    response.expectStatus().isOk();
    final WalletExtendedV1DTO walletExtendedV1DTO = response.expectBody(WalletExtendedV1DTO.class).returnResult().getResponseBody();
    assertThat(walletExtendedV1DTO)
        .extracting("transactions").asList().first()
        .hasFieldOrPropertyWithValue("amount", 20L);
  }


  @Test
  void createDeposit() {
    // Arrange
    final Wallet wallet = new Wallet();
    wallet.setNickname(WALLET_NICKNAME);
    wallet.setBalance(0L);
    final Wallet savedWallet = walletRepository.save(wallet).block();
    final DepositRequestV1DTO depositRequestV1DTO = new DepositRequestV1DTO()
        .amount(25L);

    // Act
    final WebTestClient.ResponseSpec response = this.webClient.post()
        .uri(BASE_PATH + "/"+ savedWallet.getId()  + "/deposit")
        .body(Mono.just(depositRequestV1DTO), DepositRequestV1DTO.class)
        .accept(MediaType.APPLICATION_JSON)
        .exchange();

    // Assert
    response.expectStatus().isOk();
  }
}
