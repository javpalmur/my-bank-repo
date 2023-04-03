package org.javpm.mybank.infrastructure.apirest.controllers;

import org.javpm.mybank.application.commands.CreateWalletCommandHandler;
import org.javpm.mybank.application.queries.FindWalletQueryHandler;
import org.javpm.mybank.infrastructure.apirest.mappers.WalletV1DTOMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ServerWebExchange;

@ExtendWith(MockitoExtension.class)
class WalletV1ControllerTest {

  private WalletV1Controller walletV1Controller;

  @Mock
  private ServerWebExchange serverWebExchange;

  @Mock
  private CreateWalletCommandHandler createWalletCommandHandler;

  @Mock
  private FindWalletQueryHandler findWalletQueryHandler;

  @Mock
  private WalletV1DTOMapper walletV1DTOMapper;

  @BeforeEach
  public void setUp() {
//    this.walletV1Controller = new WalletV1Controller(createWalletCommandHandler, findWalletQueryHandler, walletV1DTOMapper);
  }

  @Test
  void shouldFindWalletById() {

  }
}
