package com.example.boot.test.dialogue.dialoguetest213.services.rabbit;

import com.microideation.app.dialogue.annotations.PublishEvent;
import com.microideation.app.dialogue.event.EventStore;
import com.microideation.app.dialogue.service.DialogueEventBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class DialogueRabbitProducer {
	
	public  final String QUEUE_NAME="com.microideation.dialogue.test";
	
	private final DialogueEventBus dialogueEventBus;
	
	DialogueRabbitProducer(DialogueEventBus dialogueEventBus) {
		this.dialogueEventBus = dialogueEventBus;
	}
	
//	@Scheduled(fixedRate = 10000l)
	public void publishEvents() {
		
		dialogueEventBus.publish(QUEUE_NAME,"Sample Rabbit content: " + UUID.randomUUID().toString());
		
	}
	

	@PublishEvent(eventStore = EventStore.RABBITMQ, channelName = "my.test.channel")
	public String getUser(String name) {
	
		return "Hello, " + name + "!.";
	}
}
