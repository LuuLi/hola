package tp;

public class SOTerminal extends SistemaOperativo {
	
	
	
	public void tratarPaquete(Paquete p) { //ver lo de hacerlo abstrato
		
		if (p instanceof Who) {
			//ver ttl 
			String info = "SO: " + nombre + ". versión: " + version;
			PaqueteServicio paq = new SendMessage(p.getIpDest(), p.getIpOrig(), p.getTtl(), info, null);	//posible clase
		
			//FALTA ENVIO
			
	
			} else if (p instanceof ICMPRequest) {
				PaqueteServicio paq = new ICMPResponse(p.getIpDest(), p.getIpOrig(), p.getTtl());	
				
				//falt env
			} else if (p instanceof ICMPResponse) {
				//ver timestamp
					System.out.println("Recibido ICMP desde " + p.getIpOrig().toString());
					
				} else if (p instanceof SendMessage) {
					System.out.println(((SendMessage)p).getInfo());
			}
		}
}
