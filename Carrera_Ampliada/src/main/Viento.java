package main;

public class Viento {
	
private static boolean hayViento = false;
private static boolean turno = false;

	public static void iniciarViento() {
		int vientoRandom = (int) (Math.random()*10 + 1);
		if (vientoRandom >= 8) {
			hayViento = true;
			System.out.println("Hay viento");
		} else if (vientoRandom < 8) {
			hayViento = false;
			System.out.println("No hay viento");		
		}
	}
	
	public static void resetearViento() {
		turno = true;
	}

	public static boolean isHayViento() {
		return hayViento;
	}
}
