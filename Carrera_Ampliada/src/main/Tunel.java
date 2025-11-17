package main;

public class Tunel {
	
	private boolean tunel = false;
	
	public synchronized void ticketEntrada() throws InterruptedException {
		while(tunel) {
			wait();
		}
		
		tunel = true;
	}
	
	public synchronized void dejarTicket() {
		tunel = false;
		notify();
	}
}