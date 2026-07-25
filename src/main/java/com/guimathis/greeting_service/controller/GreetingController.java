package com.guimathis.greeting_service.controller;

import com.guimathis.greeting_service.config.GreetingConfiguration;
import com.guimathis.greeting_service.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

    @RestController
    public class GreetingController {

        private static final String template = "%s, %s!";
        private final AtomicLong counter = new AtomicLong();

        @Autowired
        GreetingConfiguration configuration;

        /**
         * Recebe as configurações do Config Server e retorna uma saudação personalizada.
         */
        @RequestMapping("/greeting")
        public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name){
            if(name.isEmpty()){
                name = configuration.getDefaultValue();
            }
            return  new Greeting(
                    counter.incrementAndGet(),
                    String.format(template, configuration.getGreeting(),
                            name));
        }
    }
