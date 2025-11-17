package main;

public class Viento implements Runnable{
	
private static boolean hayViento = false;

	public void iniciarViento() {
		int vientoRandom = (int) (Math.random()*10 + 1);
		if (vientoRandom >= 8) {
			hayViento = true;
			System.out.println("Hay viento");
		} else if (vientoRandom < 8) {
			hayViento = false;
			System.out.println("No hay viento");		
		}
	}
	
	public static synchronized boolean isHayViento() {
		return hayViento;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			iniciarViento();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}