package main; //Esto asi tal cual, cambiar el nombre de las variables y eso porfa

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
}

