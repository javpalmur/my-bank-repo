package com.javpm.mybank.application.commands;

import reactor.core.publisher.Mono;

public interface CommandHandler<T extends Command, E> {

  Mono<E> execute(T command);
}