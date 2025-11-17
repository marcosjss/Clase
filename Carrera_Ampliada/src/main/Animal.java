package main;

public abstract class Animal {
	protected  String nombre;
	protected Thread viento;

	public Animal(String nombre, Thread viento) {
		super();
		this.nombre = nombre;
		this.viento = viento;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract void avanzar();
		public String getNombre() {
			return nombre;
	}

	protected abstract int getAvanza();
}