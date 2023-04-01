package com.javpm.mybank.application.commands;

import com.javpm.mybank.application.mappers.SaveUserCommandMapper;
import com.javpm.mybank.domain.User;
import com.javpm.mybank.domain.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class SaveUserCommandHandler implements SaveCommandHandler<SaveUserCommand, User>{

  private final UserRepository userRepository;

  private final SaveUserCommandMapper commandMapper;

  @Override
  public Mono<User> execute(SaveUserCommand command) {
    return Mono.just(command)
        .map(commandMapper::asUser)
        .flatMap(userRepository::save);
  }
}
