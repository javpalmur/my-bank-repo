package com.javpm.mybank.infrastructure.apirest.controllers;

import java.net.URI;

import com.javpm.mybank.application.commands.CreateDepositCommand;
import com.javpm.mybank.application.queries.QueryHandler;
import com.javpm.mybank.infraastructure.apirest.apis.WalletV1Api;
import com.javpm.mybank.infraastructure.apirest.model.DepositRequestV1DTO;
import com.javpm.mybank.infraastructure.apirest.model.TransferRequestV1DTO;
import com.javpm.mybank.infraastructure.apirest.model.WalletRequestV1DTO;
import com.javpm.mybank.infraastructure.apirest.model.WalletV1DTO;
import com.javpm.mybank.application.commands.CommandHandler;
import com.javpm.mybank.application.commands.CreateWalletCommand;
import com.javpm.mybank.domain.model.Wallet;
import com.javpm.mybank.infrastructure.apirest.mappers.WalletV1DTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class WalletV1Controller implements WalletV1Api {

  private final CommandHandler<CreateWalletCommand, Wallet> createWalletCommandHandler;

  private final CommandHandler<CreateDepositCommand, Void> createDepositTransactionCommandHandler;

  private final QueryHandler<Integer, Mono<Wallet>> findWalletQueryHandler;

  private final WalletV1DTOMapper walletV1DTOMapper;

  public Mono<ResponseEntity<Void>> createWallet(Mono<WalletRequestV1DTO> walletRequestV1DTO, ServerWebExchange exchange) {
    return walletRequestV1DTO
        .map(this.walletV1DTOMapper::asSaveWalletCommand)
        .flatMap(this.createWalletCommandHandler::execute)
        .map(this.walletV1DTOMapper::asWalletV1DTO)
        .map(walletV1DTO -> ResponseEntity.created(URI.create(exchange.getRequest().getURI() + "/" + walletV1DTO.getId())).build());
  }

  @Override
  public Mono<ResponseEntity<WalletV1DTO>> getWalletFromId(Integer walletId, ServerWebExchange exchange) {
    return Mono.just(walletId)
        .flatMap(this.findWalletQueryHandler::execute)
        .map(this.walletV1DTOMapper::asWalletV1DTO)
        .map(ResponseEntity::ok);
  }

  @Override
  public Mono<ResponseEntity<Void>> depositInWallet(Integer walletId, Mono<DepositRequestV1DTO> depositRequestV1DTO,
      ServerWebExchange exchange) {
    return depositRequestV1DTO
        .map(request -> this.walletV1DTOMapper.asCreateDepositCommand(request, walletId))
        .flatMap(this.createDepositTransactionCommandHandler::execute)
        .map(ResponseEntity::ok);
  }



  @Override
  public Mono<ResponseEntity<Void>> transfer(Mono<TransferRequestV1DTO> transferRequestV1DTO, ServerWebExchange exchange) {
    return WalletV1Api.super.transfer(transferRequestV1DTO, exchange);
  }
}
