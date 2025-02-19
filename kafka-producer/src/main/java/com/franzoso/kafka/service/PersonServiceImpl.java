package com.franzoso.kafka.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.franzoso.domain.PersonDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.function.BiConsumer;

@Service
@Log4j2
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void createEvent(PersonDTO personDTO) {
        PersonDTO personKafka = new PersonDTO(personDTO.getName(), personDTO.getEmail(), personDTO.getAge());
        kafkaTemplate.send("topic-1", personDTO)
                .whenComplete(getResultSendMessage(personKafka));
    }

    private static BiConsumer<SendResult<String, Object>, Throwable> getResultSendMessage(PersonDTO personDTO) {
        return (success, ex) -> {
            if (ex != null) {
                log.error("::: Error sending KAFKA Message ::: {}", personDTO.toString());
            } else {
                log.info("::: Success sending KAFKA Message ::: {}", personDTO.toString());
            }
        };
        }
}
