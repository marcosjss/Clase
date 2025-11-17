package main;

public abstract class Animal {
	protected  String nombre;

	public Animal(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract void avanzar();
		public String getNombre() {
			return nombre;
	}

	protected abstract int getAvanza();


	public static boolean isHayViento() {
		return Viento.isHayViento();
	}
}
