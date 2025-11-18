package main; //Esto asi tal cual

public class Main {

	public static void main(String[] args) {		
		Tunel tunel = new Tunel ();
		
		Thread tortuga = new Thread(new Carrera (tunel, new Tortuga("Tortuga")));
		Thread liebre = new Thread(new Carrera (tunel, new Liebre("Liebre")));
		Thread pajaro = new Thread(new Carrera (tunel, new Pajaro("Pajaro")));
		
		tortuga.start();
		liebre.start();
		pajaro.start();

	}


}
