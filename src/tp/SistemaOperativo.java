package tp;

public abstract class SistemaOperativo {
	
	
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
