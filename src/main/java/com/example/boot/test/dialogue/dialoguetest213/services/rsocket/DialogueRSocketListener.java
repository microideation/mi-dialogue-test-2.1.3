package com.example.boot.test.dialogue.dialoguetest213.services.rsocket;

import com.microideation.app.dialogue.annotations.DialogueEventListener;
import com.microideation.app.dialogue.annotations.SubscribeEvent;
import com.microideation.app.dialogue.event.DialogueEvent;
import com.microideation.app.dialogue.event.EventStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@DialogueEventListener
public class DialogueRSocketListener {
	
	public final String SOCKET_ADDR="127.0.0.1:9091";
	
	@SubscribeEvent(eventStore = EventStore.RSOCKET,channelName = SOCKET_ADDR)
	public void receiveEvent(DialogueEvent event) {
		
		log.info("RSocket Event received:" + event);
	}
}
