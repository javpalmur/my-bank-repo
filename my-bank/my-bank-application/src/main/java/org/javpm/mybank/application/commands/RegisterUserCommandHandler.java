package org.javpm.mybank.application.commands;

import org.javpm.mybank.application.mappers.RegisterUserCommandMapper;
import org.javpm.mybank.domain.model.User;
import org.javpm.mybank.domain.repositories.UserRepository;
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
