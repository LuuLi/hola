package tp;

import java.util.ArrayList;

public class TablaRuteo {

	private ArrayList<IP> direcciones;
	private ArrayList<IP> interfaces;
	
	public void agregarRuta(IP destino, IP interfaz) {
		direcciones.add(destino);
		interfaces.add(interfaz);
	}
	
	public void eliminarRuta() {
		
	}
	
	public boolean pertenece(IP direccion) {
		return direcciones.contains(direccion);
	}
	
	
}
