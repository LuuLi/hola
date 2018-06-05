package tp;


public class Router extends Dispositivo {

	private IP[] interfaces = new IP[CANT_INTERFACES];
	private IP intDefault;
	private SORouter sistema;
	private static int CANT_INTERFACES; 
	private TablaRuteo tabla;
	
	
	public Router(SORouter sist) {
		sistema = sist;
		CANT_INTERFACES = sistema.getCantInterfaces();
	}

	@Override
	public void recibir(Paquete p) {
		
		boolean pertenece = false;
		int i = 0;
		while(i<CANT_INTERFACES && !pertenece) {
			if(interfaces[i] == p.getIpDest()) {
				pertenece = true;
			}else {
				i++;
			}
		}
		
		if (pertenece) {
			sistema.tratarPaquete(p, tabla, intDefault);
		}
		
		
	}
	
	
}
