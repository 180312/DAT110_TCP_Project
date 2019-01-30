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
		byte[] encoded = payload;
		// TODO
		// encapulate/encode the payload of the message
		int length = encoded.length;
		for(int i = length; i>0; i--) {
			encoded[i] = encoded[i-1];
		}
		encoded[0] = (byte) length;
		
		return encoded;
		
	}

	public void decapsulate(byte[] received) {
		// TODO
		// decapsulate data in received and put in payload
		for (int i = 0; i<received.length; i++) {
			received[0] = received[i+1];
		}
	   
		this.payload = received;
		
	}
}
