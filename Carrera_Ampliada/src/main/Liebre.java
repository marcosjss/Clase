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
		if (liebreVaga != 4) {
            	this.avanza = this.avanza + this.velocidad;
    			System.out.println("La liebre " + nombre + " ha avanzando " + this.avanza + " metros");
    			liebreVaga ++;
    			segundosQuieta = 10;
    			
		}	else if (liebreVaga == 4) {
				System.out.println("La liebre " + nombre + " se ha dormido y no avanzara hasta dentro de " + segundosQuieta + " segundos");
				segundosQuieta --;
				
				if (segundosQuieta == 0) {
					liebreVaga = 0;
				}
		}
		
	}
}
	

