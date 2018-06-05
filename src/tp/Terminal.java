package tp;

import java.util.ArrayList;

public class Terminal extends Dispositivo {
	private String dispositivo;
	private SOTerminal sistema;
	private Hub interfaz;
	private ArrayList<IP> direcciones;
	private IP defaultGateway;
	
	public Terminal(String disp, SOTerminal sist, Hub inter, ArrayList<IP> direc, IP dg){
		dispositivo = disp;
		sistema = sist;
		interfaz = inter;
		direcciones = direc;
		defaultGateway = dg;
	}
	
/*	public void EnvioPaquete(Paquete p) {
		if (direcciones.contains(p.ipDest)){
			obtenerTerminal(p.ipDest);
		} else {
			PaqueteRuteo paq = new PaqueteRuteo(p.getIpOrig(), defaultGateway, p.getTtl(), p);
		} 
		//interfaz
	}
*/	
	public void recibir(Paquete p) {
		if (direcciones.contains(p.getIpDest())){
			//ver ttl
			if (p instanceof PaqueteServicio) {
			
					sistema.tratarPaquete(p);
				
			}
		}
	}
			
	
}



