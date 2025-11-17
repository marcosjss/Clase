package main;

public class Pajaro extends Animal {
	private int velocidad = 3;
	private int avanza = 0;
	int volarRandom;

	public Pajaro(String nombre) {
		super(nombre);
	}

	public int getAvanza() {
		return avanza;
	}

	@Override
	public void avanzar() {
		
		volar();
		
		if (avanza > 40 && avanza < 50) {
			avanza = 50;
			System.out.println("El pajaro " + nombre + " hecho a volar y avanzo hasta los " + this.avanza + " metros");
			
		} else if (avanza > 140 && avanza < 150) {
			avanza = 150;
			System.out.println("El pajaro " + nombre + " hecho a volar y avanzo hasta los " + this.avanza + " metros"); 
			
		} else {
			
			if (velocidad == 3) {
				this.avanza = this.avanza + this.velocidad;
					System.out.println("El pajaro " + nombre + " ha avanzando " + this.avanza + " metros");
					
			} else if (velocidad == 10) {				
				this.avanza = this.avanza + this.velocidad;
					System.out.println("El pajaro " + nombre + " hecho a volar y avanzo hasta los " + this.avanza + " metros");
					
			} else if (velocidad == -10) {
				if (avanza >= 50 && avanza <= 61 || avanza >= 150 && avanza <= 161) {
					while (velocidad == -10) {
						volar();
					}
						this.avanza = this.avanza + this.velocidad;
						System.out.println("El pajaro " + nombre + " ha avanzando " + this.avanza + " metros");
					}
				} else {
					this.avanza = this.avanza + this.velocidad;
					System.out.println("Oh no, tu pajaro " + nombre + " esta tan confuso que volo hacia atras y retrocedio hasta los " + this.avanza + " metros");
				}
			
		}
	}
	
	
	public void volar() {
		int volarRandom = (int) (Math.random()*10 + 1);
		if (volarRandom > 7) {
			this.velocidad = 10;
		} else if (volarRandom < 3) {
			this.velocidad = -10;
		} else {
			this.velocidad = 3;
		}
	}
}
