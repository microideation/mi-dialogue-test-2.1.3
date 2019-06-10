package com.example.boot.test.dialogue.dialoguetest213.services.rsocket;

import com.microideation.app.dialogue.service.DialogueEventBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class DialogueRSocketProducer {
	
	public  final String SOCKET_ADDR="127.0.0.1:9091";
	
	private final DialogueEventBus dialogueEventBus;
	
	DialogueRSocketProducer(DialogueEventBus dialogueEventBus) {
		this.dialogueEventBus = dialogueEventBus;
	}
	
//	@Scheduled(fixedRate = 10000l)
	public void publishEvents() {
		
		dialogueEventBus.publish(SOCKET_ADDR,"Sample Rabbit content: " + UUID.randomUUID().toString());
		
	}
}
