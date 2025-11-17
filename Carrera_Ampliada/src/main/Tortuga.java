package main;

public class Tortuga extends Animal {
	private int velocidad = 2;
	private int avanza = 0;

	public Tortuga(String nombre, Thread viento) {
		super(nombre, viento);
	}


	public int getAvanza() {
		return avanza;
	}

	@Override 
	public void avanzar() {
		this.avanza = this.avanza + this.velocidad;
		System.out.println("La tortuga " + nombre + " ha avanzando " + this.avanza + " metros");
		
	}
}