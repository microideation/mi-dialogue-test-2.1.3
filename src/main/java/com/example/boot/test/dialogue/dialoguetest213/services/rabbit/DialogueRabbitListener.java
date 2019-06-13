package com.example.boot.test.dialogue.dialoguetest213.services.rabbit;

import com.microideation.app.dialogue.annotations.DialogueEventListener;
import com.microideation.app.dialogue.annotations.SubscribeEvent;
import com.microideation.app.dialogue.event.DialogueEvent;
import com.microideation.app.dialogue.event.EventStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@DialogueEventListener
public class DialogueRabbitListener {
	
	public  final String QUEUE_NAME="com.microideation.dialogue.test";
	
	@SubscribeEvent(eventStore = EventStore.RABBITMQ,channelName = QUEUE_NAME)
	public void receiveEvent(DialogueEvent event) {
		
		log.info("Rabbit Event received:" + event);
	}
}
