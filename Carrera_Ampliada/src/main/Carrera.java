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
			if (animal.getAvanza() == 50) {
				try {
					tunel.ticketEntrada();
					System.out.println("**** " + animal.getNombre() + " entro en el tunel ****");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else if (animal.getAvanza() == 150) {
				tunel.dejarTicket();
				System.out.println("**** " + animal.getNombre() + " salio del tunel ****");
			}
			
			animal.avanzar();
			if (animal.getAvanza() >= 300) {
				System.out.println(animal.getNombre() + " llego a la meta!");
				//return;
				System.exit(0);
			}
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
