package main;

public class Pajaro extends Animal {
	private int velocidad = 3;
	private int avanza = 0;
	private boolean volando = false;
	
	public Pajaro(String nombre) {
		super(nombre);
	}

	public int getAvanza() {
		return avanza;
	}

	@Override
	public void avanzar() {
		volar();
		if (llegarAlTunel() == true) {
			llegarAlTunel();
			
		} else if (volandoConViento() == true) {
			pajaroVolando();
			
		} else {
			if (velocidad == 3 || velocidad == 10) {
				pajaroAvanza();
					
			} else if (velocidad == -10) {
				retroceder();
			}
		}
	}
	
	public void volar() {
		int volarRandom = (int) (Math.random()*10 + 1);
		if (volarRandom > 7) {
			this.velocidad = 10;
			volando = true;
		} else if (volarRandom < 3) {
			this.velocidad = -10;
			volando = true;
		} else {
			this.velocidad = 3;
			volando = false;
		}
	}
	
	public boolean volandoConViento() {
		return (volando == true && Animal.isHayViento() == true);
	}
	
	public void pajaroVolando() {
		velocidad +=5;		
		if (velocidad == 15) {
			this.avanza = this.avanza + this.velocidad;
				System.out.println("El pajaro " + nombre + " hecho a volar a favor del viento y avanzo hasta los " + this.avanza + " metros");
		} else if (velocidad == -5) {
			this.avanza = this.avanza + this.velocidad;
				System.out.println("Oh no, tu pajaro " + nombre + " esta tan confuso que volo hacia atras en contra del viento y retrocedio hasta los " + this.avanza + " metros");
		}
	}
	
	public boolean llegarAlTunel() { //Para que no se pase de la entrada/salida del tunel
		if (avanza >= 35 && avanza < 50) {
			if (volandoConViento() == true) {
				avanza = 50;
				System.out.println("El pajaro " + nombre + " hecho a volar a favor del viento y avanzo hasta los " + this.avanza + " metros");
				return true;

			} else if (avanza >= 40) {
				avanza = 50;
				System.out.println("El pajaro " + nombre + " hecho a volar y avanzo hasta los " + this.avanza + " metros");
				return true;
			}
			
		} else if (avanza > 135 && avanza < 150) {			
			if (volandoConViento() == true) {
				avanza = 150;
				System.out.println("El pajaro " + nombre + " hecho a volar a favor del viento y avanzo hasta los " + this.avanza + " metros");
				return true;
				
			} else if (avanza >= 140){
				avanza = 150;
				System.out.println("El pajaro " + nombre + " hecho a volar y avanzo hasta los " + this.avanza + " metros"); 
				return true;
			}		
		}
		return false;
	}
	
	public void pajaroAvanza() {
		if (velocidad == 3) {
			this.avanza = this.avanza + this.velocidad;
				System.out.println("El pajaro " + nombre + " ha avanzando " + this.avanza + " metros");
				
		} else if (velocidad >= 10) {				
			this.avanza = this.avanza + this.velocidad;
				System.out.println("El pajaro " + nombre + " hecho a volar y avanzo hasta los " + this.avanza + " metros");
		}
	}
	
	public void retroceder() {
		if (avanza >= 50 && avanza <= 61 || avanza >= 150 && avanza <= 161 || avanza >= 45 && avanza <= 66 && volandoConViento() == true || avanza >= 145 && avanza <= 166 && volandoConViento() == true) { //Para no retroceder cerca de la entrada/salida del tunel, si no el programa se para (No sabia como hacer para solucionarlo de otra forma)
			while (velocidad < 0) {
				volar();				
			}
			pajaroAvanza();

		} else {
			this.avanza = this.avanza + this.velocidad;
				System.out.println("Oh no, tu pajaro " + nombre + " esta tan confuso que volo hacia atras y retrocedio hasta los " + this.avanza + " metros");
		}
	}
}