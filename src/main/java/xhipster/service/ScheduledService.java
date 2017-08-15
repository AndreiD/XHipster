package xhipster.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ScheduledService {

    //Every min do something. Delete if you don't need it :)

    @Scheduled(initialDelay = 500, fixedRate = 60000)
    public void send_data() throws InterruptedException, TimeoutException, IOException {
        log.info("⏳  Scheduled Service Triggered  ⏳");

    }
}