package main;

public class Liebre extends Animal{

	private int velocidad = 5;
	private int avanza = 0;
	int liebreVaga = 0;
	int segundosQuieta;
	
	public Liebre(String nombre) {
		super(nombre);
	}
	
	
	public int getAvanza() {
		return avanza;
	}
	
	@Override
	public void avanzar() {
		if (liebreVaga != 4) { //liebreVaga es un contador que mientras sea distinto de 4 avanza normalmente, 
			//sumando uno al contador de liebreVaga cada vez que avanza, y resetea el contador de segundosQuieta cada vez que se ejecuta, para asegurarme que no quede a 0
            	this.avanza = this.avanza + this.velocidad;
    			System.out.println("La liebre " + nombre + " ha avanzando " + this.avanza + " metros");
    			liebreVaga ++;
    			segundosQuieta = 10;
    			
		}	else if (liebreVaga == 4) { //Cuando liebreVaga es igual a 4, osea que ya avanzo durante 4s como dice el ejercicio, descansa 10s, se ejecuta esto y cada vez resta uno al contador de segundosQuieta
				System.out.println("La liebre " + nombre + " se ha dormido y no avanzara hasta dentro de " + segundosQuieta + " segundos");
				segundosQuieta --;
				
				if (segundosQuieta == 0) { //Cuando segundosQuieta llegan a 0 resetea liebreVaga a 0 y el bucle sigue
					liebreVaga = 0;
				}
		}
		
	}
}
	


