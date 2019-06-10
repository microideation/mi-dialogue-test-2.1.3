package com.example.boot.test.dialogue.dialoguetest213.services.kafka;

import com.microideation.app.dialogue.annotations.DialogueEventListener;
import com.microideation.app.dialogue.annotations.SubscribeEvent;
import com.microideation.app.dialogue.event.DialogueEvent;
import com.microideation.app.dialogue.event.EventStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@DialogueEventListener
public class DialogueKafkaListener {
	
	public  final String QUEUE_NAME="com.microideation.dialogue.test";
	
	// IMPORTANT: KAFKA WILL GIVE ERROR FOR REFLECTION IF USED WITH INTERNAL
	// CLASS
	@SubscribeEvent(eventStore = EventStore.KAFKA,channelName = QUEUE_NAME)
	public void receiveEvent(DialogueEvent event) {
		
		log.info("Kafka Event received:" + event);
	}
}
