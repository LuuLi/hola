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
	
	public void EnvioPaquete(Paquete P) {
		if (direcciones.contains(P.ipDest)){
			ObtenerTerminal(P.ipDest); 
		} else {
			CrearPaqueteRuteo(P, defaultGateway);
		}
	}
	
	public void Recibir(PaqueteServicio p) {
		if (direcciones.contains(p.getIpDest())){
			//ver ttl
			if (p.tieneTipoValido()) {
				tratarPaquete(p);
			}
		}
	}
			
	private void tratarPaquete(PaqueteServicio p) {
	
		String t = p.getTipo();
		
		if (t == "WHO") {
			//ver ttl 
			String info = "SO: " + nombreSO + ". versión: " + versionSO;
			PaqueteServicio paq = new PaqueteServicio(p.getIpDest(), p.getIpOrig(), p.getTtl(), "SendMessage", info);	
		
			//FALTA ENVIO
			
	
			} else if (t == "ICMPRequest") {
				PaqueteServicio paq = new PaqueteServicio(p.getIpDest(), p.getIpOrig(), p.getTtl(), "ICMPResponse", "");	
				
				//falt env
			} else if (t == "ICMPResponse") {
				//ver timestamp
					System.out.println("Recibido ICMP desde " + p.getIpOrig().toString());
					
				} else if (t == "SendMessage") {
					System.out.println(p.getInfo());
			}
		}
	}
}
