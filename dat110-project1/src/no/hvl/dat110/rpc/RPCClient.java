package no.hvl.dat110.rpc;

import no.hvl.dat110.messaging.*;

public class RPCClient {

	private MessagingClient msgclient;
	private Connection connection;

	public RPCClient(String server, int port) {

		msgclient = new MessagingClient(server, port);
	}

	public void register(RPCStub remote) {
		remote.register(this);
	}

	public void connect() {
		// connect using the underlying messaging layer connection

		try {
			connection = msgclient.connect();
		} catch (Exception e) {
			System.out.println("An error occurd: " + e);
		}

	}

	public void disconnect() {
		// disconnect using the underlying messaging layer connection
		try {
			if(connection != null) {
			connection.close();
			
			}

		} catch(Exception e) {
			System.out.println("Error occurd: " + e);
		}
	}

	public byte[] call(byte[] rpcrequest) {

		byte[] rpcreply;

		/*
		 * TODO:
		 * 
		 * Make a remote call on the RPC server by sending a request message and receive
		 * a reply message
		 * 
		 * rpcrequest is the marshalled rpcrequest from the client-stub rpctreply is the
		 * rpcreply to be unmarshalled by the client-stub
		 * 
		 */

		if (true) {
			throw new RuntimeException("not yet implemented");
		}

		return rpcreply;

	}

}
