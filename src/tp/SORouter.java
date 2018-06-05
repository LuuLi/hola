package tp;

public class SORouter extends SistemaOperativo {

	private int cantInterfaces;
	

	


	public void tratarPaquete(Paquete p, TablaRuteo tabla, IP intDefault) {
		
		if (p instanceof PaqueteServicio) {
		
			if (p instanceof Who) {
				String info = "SO: " + nombre + ". versión: " + version;
				PaqueteServicio paq = new SendMessage(p.getIpDest(), p.getIpOrig(), p.getTtl(), info, tabla);
				//env
			} else if (p instanceof ICMPRequest) {
			
				PaqueteServicio paq = new ICMPResponse(p.getIpDest(), p.getIpOrig(), p.getTtl());
				//env
			} else if (p instanceof ICMPResponse) {
					//ver timestamp
					System.out.println("Recibido ICMP desde " + p.getIpOrig().toString());
				
			}
			
		}else {
		
			p.setTtl(p.getTtl() - 1);
			if (p.getTtl() > 0) {
			
				Paquete paq = ((PaqueteRuteo)p).getSubpaquete();
				
				if (tabla.pertenece(paq.getIpDest())) {
					//CASO 1
					//enviar
				}else {
					if (intDefault == null) {
						//CASO 3
						String info = "No es posible enviar a destino.";
						PaqueteServicio paq2 = new SendMessage(p.getIpDest(), p.getIpOrig(), p.getTtl(), info, null);
						//env
					}else {
						//CASO 2
						PaqueteRuteo paq2 = new PaqueteRuteo(paq.getIpDest(), intDefault, paq.getTtl(), paq);
						//env	
					}
				}
				
			}
		}
		
	}

	public int getCantInterfaces() {
		return cantInterfaces;
	}
}
