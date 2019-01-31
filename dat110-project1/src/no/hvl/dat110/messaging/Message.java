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
		int length = payload.length;
		
		byte[] encoded = new byte[SEGMENTSIZE];
		
		for (int j = length; j>0; j--) {
			encoded[j] = payload[j-1];
		}

		encoded[0] = (byte) length;
		
		return encoded;
		
	}

	public void decapsulate(byte[] received) {
		// TODO
		// decapsulate data in received and put in payload
		int i = received[0];
		
		byte[] decoded = new byte[i];
		
		for(int j = 0; j<i; j++) {
			decoded[j] = received[j+1]; 
		}
	   
		this.payload = decoded;
		
	}
}
