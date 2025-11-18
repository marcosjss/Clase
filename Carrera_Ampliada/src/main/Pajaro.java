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
		
		volar();//LLama al numero aleatorio antes de decidir que hace
		
		if (avanza > 40 && avanza < 50) { //Esto hace que no se pueda saltar la entrada del tunel (copialo tal cual, como mucho cambia los mensajes)
			avanza = 50;
			System.out.println("El pajaro " + nombre + " hecho a volar y avanzo hasta los " + this.avanza + " metros");
			
		} else if (avanza > 140 && avanza < 150) { //Esto hace que no se pueda saltar la salida del tunel (copialo tal cual, como mucho cambia los mensajes)
			avanza = 150;
			System.out.println("El pajaro " + nombre + " hecho a volar y avanzo hasta los " + this.avanza + " metros"); 
			
		} else {
			
			if (velocidad == 3) { //Esto yo lo tengo hehco asi para que de un mensaje diferente cuando camine o vuele, si la velocidad es 3 da este mensaje
				this.avanza = this.avanza + this.velocidad;
					System.out.println("El pajaro " + nombre + " ha avanzando " + this.avanza + " metros");
					
			} else if (velocidad == 10) {//Si la velocidad es 10 da este, por lo demas funcionan igual los dos				
				this.avanza = this.avanza + this.velocidad;
					System.out.println("El pajaro " + nombre + " hecho a volar y avanzo hasta los " + this.avanza + " metros");
					
			} else if (velocidad == -10) { //Y esto es para cuando vuela hacia atras, ten cuidado con los {} de esta parte que se puede liar si no los pones asi tal cual
				if (avanza >= 50 && avanza <= 61 || avanza >= 150 && avanza <= 161) { //Esto hace que si esta cerca de la salida o entrada del tunel no pueda retroceder, 
					//y genere aleatoriamente otra vez si volar o caminar, pero nunca retroceder, tambien te recomiendo que lo hagas asi, te ahorras problemas
					while (velocidad == -10) { // Mientras la velocidad sea -10 vuelve a llamar "volar()" para impedir que salga del tunel, o vuelva a entrar en el caso de la salida
						volar();
					}
						this.avanza = this.avanza + this.velocidad; //Y nada esto lo mismo de arriba, dice cuando avanza
						System.out.println("El pajaro " + nombre + " ha avanzando " + this.avanza + " metros");
					}
				} else { //Y este es mensaje de retroceder
					this.avanza = this.avanza + this.velocidad; 
					System.out.println("Oh no, tu pajaro " + nombre + " esta tan confuso que volo hacia atras y retrocedio hasta los " + this.avanza + " metros");
				}
			
		}
	}
	
	
	public void volar() { //Decide si el pajaro vuela o camina
		int volarRandom = (int) (Math.random()*10 + 1); //Genera un numero aleatorio entre 0 y 10 (copialo tal cual)
		if (volarRandom > 7) { //Si es mayor de 7 "vuela" 
			this.velocidad = 10;
		} else if (volarRandom < 3) { //si es menor de 3 "vuela hacia atras"
			this.velocidad = -10;
		} else { //Si no camina
			this.velocidad = 3;
		}
	}
}

