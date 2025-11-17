package main;

public class Main {

	public static void main(String[] args) {		
		Tunel tunel = new Tunel ();
		Thread viento = new Thread(new Viento ());
		
		Thread tortuga = new Thread(new Carrera (tunel, new Tortuga("Tortuga", viento)));
		Thread liebre = new Thread(new Carrera (tunel, new Liebre("Liebre", viento)));
		Thread pajaro = new Thread(new Carrera (tunel, new Pajaro("Pajaro", viento)));

		viento.start();
		tortuga.start();
		liebre.start();
		pajaro.start();

	}

}