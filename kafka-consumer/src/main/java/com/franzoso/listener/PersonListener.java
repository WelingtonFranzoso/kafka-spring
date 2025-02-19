package com.franzoso.listener;

import lombok.extern.log4j.Log4j2;
import org.franzoso.domain.PersonDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class PersonListener {

    @KafkaListener(
            topics = "topic-1",
            groupId = "group-one",
            containerFactory = "containerFactory"
    )
    public void messageListener(@Payload PersonDTO personDTO) {
        log.info("::: Message received | Payload {}", personDTO.toString());
    }
}
