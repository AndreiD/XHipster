package xhipster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class Application {

    public static void main(String[] args) throws IOException {
        ApplicationContext appContext = SpringApplication.run(Application.class, args);

        log.info(":::::::::::::::::::: Running on http://localhost:1337 ::::::::::::::::::::");
        log.info(":::::::::::::::::::: on Spring "+  org.springframework.core.SpringVersion.getVersion() +" ::::::::::::::::::::");

    }
}
