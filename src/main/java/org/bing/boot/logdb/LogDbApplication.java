package org.bing.boot.logdb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Slf4j
@RestController
public class LogDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogDbApplication.class, args);
    }

    @GetMapping("/{path}")
    public String home(@PathVariable("path") String path) {
        // trace < debug < info < warn < error
        log.warn("home" + path);
        return "home";
    }

    @Bean
    public CommandLineRunner start() {
        return (args) -> {
            log.warn("LogDbApplication Ok");
        };
    }

}
