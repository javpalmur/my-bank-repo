package com.javpm.mybank.domain.repositories;

import com.javpm.mybank.domain.User;
import com.javpm.mybank.domain.Wallet;
import reactor.core.publisher.Mono;

public interface UserRepository {

  Mono<User> save(User user);
}
