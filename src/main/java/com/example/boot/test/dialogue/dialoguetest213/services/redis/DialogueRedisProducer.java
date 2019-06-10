package com.example.boot.test.dialogue.dialoguetest213.services.redis;

import com.microideation.app.dialogue.event.EventStore;
import com.microideation.app.dialogue.service.DialogueEventBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class DialogueRedisProducer {
	
	public  final String QUEUE_NAME="com.microideation.dialogue.test";
	
	private final DialogueEventBus dialogueEventBus;
	
	DialogueRedisProducer(DialogueEventBus dialogueEventBus) {
		this.dialogueEventBus = dialogueEventBus;
	}
	
//	@Scheduled(fixedRate = 10000l)
	public void publishEvents() {
		
		dialogueEventBus.publish(QUEUE_NAME, EventStore.REDIS,"Sample Redis content: " + UUID.randomUUID().toString());
	}
}
