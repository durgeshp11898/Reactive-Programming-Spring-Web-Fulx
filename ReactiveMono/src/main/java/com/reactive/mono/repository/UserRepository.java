package com.reactive.mono.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.reactive.mono.entity.User;

import reactor.core.publisher.Mono;


@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Long> {
    Mono<User> findByEmail(String email);
}
