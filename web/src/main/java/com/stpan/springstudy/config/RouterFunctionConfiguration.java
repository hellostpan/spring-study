package com.stpan.springstudy.config;

import com.stpan.springstudy.domain.User;
import com.stpan.springstudy.repository.UserOperaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * author:  STPAN
 * time:    2018/3/25 22:32
 */
@Configuration
public class RouterFunctionConfiguration {

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserOperaRepository userOperaRepository){
        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),request->{
            Collection<User> users = userOperaRepository.findAll();
            Flux<User> flux = Flux.fromIterable(users);
            return ServerResponse.ok().body(flux,User.class);
        });
    }

}
