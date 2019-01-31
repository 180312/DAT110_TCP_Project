package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.RPCClient;
import no.hvl.dat110.rpc.RPCServerStopStub;

public class Controller {

	private static int N = 5;

	public static void main(String[] args) {

		Display display;
		Sensor sensor;
		RPCClient displayclient;
		RPCClient sensorclient;

		System.out.println("Controller starting ...");

		RPCServerStopStub stopdisplay = new RPCServerStopStub();
		RPCServerStopStub stopsensor = new RPCServerStopStub();

		// create display and sensor object
		// create RPC clients for display device and sensor device
		// register RPC methods in the RPC layer
		display = new Display();
		sensor = new Sensor();
		displayclient = new RPCClient(Common.DISPLAYHOST, Common.DISPLAYPORT);
		sensorclient = new RPCClient(Common.SENSORHOST, Common.SENSORPORT);
		displayclient.register(sensor);
		sensorclient.register(sensor);

		// register stop methods in the RPC middleware
		displayclient.register(stopdisplay);
		sensorclient.register(stopsensor);

		// loop while reading from sensor and write to display via RPC
		try {
			while (true) {

				int value = sensor.read();
				display.write("sensor: " + value);
				return;
			}
		} catch (Exception e) {
			System.out.println("Error occurred: " + e);
		}

		stopdisplay.stop();
		stopsensor.stop();

		displayclient.disconnect();
		sensorclient.disconnect();

		System.out.println("Controller stopping ...");

	}
}
