package com.example.boot.test.dialogue.dialoguetest213;

import com.microideation.app.dialogue.event.EventStore;
import com.microideation.app.dialogue.service.DialogueEventBus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TestController {

	private final DialogueEventBus dialogueEventBus;

	@PostMapping("test/event/{eventStore}/post")
	public String postEvent(@RequestParam  String data,
	                        @RequestParam  String channelName,
	                        @PathVariable EventStore eventStore) {
	
		// Log the request
		log.info("postEvent -> Received request - data: " + data + " - Eventstore: " + eventStore + " - Channel name: " + channelName);
		
		// Publish the event
		dialogueEventBus.publish(channelName,eventStore,data);
		
		// Return
		return "posted";
		
	}
}
