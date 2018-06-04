package tp;

public class PaqueteServicio extends Paquete {
	protected String tipo; // who servicio
	private String info;

	public PaqueteServicio(IP ipOrig, IP ipDest, int ttl, String tipo, String info) {
		super(ipOrig, ipDest, ttl);
		this.tipo = tipo;
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public boolean tieneTipoValido() {
		return tipo == "WHO" || tipo == "ICMPRequest" || tipo == "IMCPResponse" || tipo == "SendMessage";
	}

}
