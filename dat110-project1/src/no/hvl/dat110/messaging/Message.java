package no.hvl.dat110.messaging;
import static no.hvl.dat110.messaging.MessageConfig.SEGMENTSIZE;

import java.util.Arrays;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		if(payload.length <= SEGMENTSIZE) {
			this.payload = payload;
		} else {
			System.out.println("Message too long");
		}
		
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

	public byte[] encapsulate() {
		byte[] encoded;
		
		// TODO
		// encapulate/encode the payload of the message
		
		if (true) {
		   throw new RuntimeException("not yet implemented");
		}
		
		return encoded;
		
	}

	public void decapsulate(byte[] received) {
		this.payload = received;
		// TODO
		// decapsulate data in received and put in payload
		
	   throw new RuntimeException("not yet implemented");
		
	}
}
