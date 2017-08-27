package xhipster.config;

import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Slf4j
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "xhipster")
@Data
public class XHipsterConfig {

  private String appname;

  @PostConstruct
  public void after_init() {
    log.info("███████████████████ " + appname + " ███████████████████");
  }
}