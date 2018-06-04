package tp;

import java.util.ArrayList;

public class Terminal extends Dispositivo {
	private String dispositivo;
	private String nombreSO;
	private String versionSO;
	private Hub interfaz;
	private ArrayList<IP> direcciones;
	private IP defaultGateway;
	
	public Terminal(String Disp, String NSO, String VSO, Hub inter, ArrayList<IP> direc, IP DG){
		dispositivo = Disp;
		nombreSO = NSO;
		versionSO = VSO;
		interfaz = inter;
		direcciones = direc;
		defaultGateway = DG;
	}
	
	public void EnvioPaquete(Paquete p) {
		if (direcciones.contains(p.ipDest)){
			obtenerTerminal(p.ipDest);
		} else {
			PaqueteRuteo paq = new PaqueteRuteo(p.getIpOrig(), defaultGateway, p.getTtl(), p);
		} 
		//interfaz
	}
	
	public void recibir(Paquete p) {
		if (direcciones.contains(p.getIpDest())){
			//ver ttl
			if (p instanceof PaqueteServicio) {
				if ( ((PaqueteServicio) p).tieneTipoValido()) {
					tratarPaquete((PaqueteServicio) p);//en sistema operativo
				}
			}
		}
	}
			
	
}

	}

