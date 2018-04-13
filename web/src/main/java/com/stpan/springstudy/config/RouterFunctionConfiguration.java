package com.stpan.springstudy.config;

import org.springframework.context.annotation.Configuration;

/**
 * author:  STPAN
 * time:    2018/3/25 22:32
 */
@Configuration
public class RouterFunctionConfiguration {

    /*@Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserOperaRepository userOperaRepository){
        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),request->{
            Collection<User> users = userOperaRepository.findAll();
            Flux<User> flux = Flux.fromIterable(users);
            return ServerResponse.ok().body(flux,User.class);
        });
    }*/

}
