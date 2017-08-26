package xhipster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Application {

  public static void main(String[] args) throws IOException {
    ApplicationContext appContext = SpringApplication.run(Application.class, args);

    log.info(":::::::::::::::::::: Spring " + org.springframework.core.SpringVersion.getVersion() + " ::::::::::::::::::::");
    log.info(":::::::::::::::::::: Running on http://localhost:1337 ::::::::::::::::::::");
  }
}
