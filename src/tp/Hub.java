package tp;

import java.util.ArrayList;

public class Hub extends Dispositivo {

	private ArrayList<Dispositivo> puertos;
	private static int cantPuertos;
	
	public Hub(int cant) {
		cantPuertos = cant;
	}

	public void conectarAHub(Dispositivo disp) {
		if (!(puertos.contains(disp))) {
			if (puertos.size() == cantPuertos) {
				System.out.println("El hub esta lleno");
			} else {
				puertos.add(disp);
			}
		} else {
			System.out.println("El dispositivo ya se encuentra conectado al hub");
		}
	}
	
	public void recibir(Paquete p) {
		reenviarPaquete(p);
	}

	public void reenviarPaquete(Paquete P) {
		for (Dispositivo x : puertos) {
			x.recibir(P);
		}
	}

}
