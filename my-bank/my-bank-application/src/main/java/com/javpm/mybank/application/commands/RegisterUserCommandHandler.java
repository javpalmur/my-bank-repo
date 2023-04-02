package com.javpm.mybank.application.commands;

import com.javpm.mybank.application.mappers.RegisterUserCommandMapper;
import com.javpm.mybank.domain.model.User;
import com.javpm.mybank.domain.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class RegisterUserCommandHandler implements CommandHandler<RegisterUserCommand, User> {

  private final UserRepository userRepository;

  private final RegisterUserCommandMapper commandMapper;

  @Override
  public Mono<User> execute(RegisterUserCommand command) {
    return Mono.just(command)
        .map(commandMapper::asUser)
        .flatMap(userRepository::save);
  }
}
