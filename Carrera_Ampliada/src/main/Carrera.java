package main;

public class Carrera implements Runnable{

	public Tunel tunel;
	public Animal animal;
	
	
	
	public Carrera(Tunel tunel, Animal animal) {
		this.tunel = tunel;
		this.animal = animal;
	}

	@Override
	public void run() {
		for (int k = 0; k < 300; k++) {
			if (animal.getAvanza() == 50) { //Entrar al tunel
				try {
					tunel.ticketEntrada();
					System.out.println("**** " + animal.getNombre() + " entro en el tunel ****");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else if (animal.getAvanza() == 150) { //Salir del tunel
				tunel.dejarTicket();
				System.out.println("**** " + animal.getNombre() + " salio del tunel ****");
			}
			
			animal.avanzar(); //Avanza el animal segun sus condiciones
			if (animal.getAvanza() >= 300) { //La meta
				System.out.println(animal.getNombre() + " llego a la meta!");
				//return;
				System.exit(0); //Esto cierra el programa cuando llega a la meta uno, si haces solo return cierra un hilo
			}
			
			try {
				Thread.sleep(500); //El tiempo de ejecucion
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}


