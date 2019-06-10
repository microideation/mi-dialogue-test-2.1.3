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
	@SubscribeEvent(eventStore = EventStore.RABBITMQ,channelName = "my.test.channel")
	public void receiveEvent(DialogueEvent event) {
		
		log.info("Rabbit Event received:" + event);
	}
}
