package tp;

import java.util.Scanner;

public class IP {
	private int oct1;
	private int oct2;
	private int oct3;
	private int oct4;
	
	public IP(int po, int so, int to, int co) {
		oct1 = po;
		oct2 = so;
		oct3 = to;
		oct4 = co;
	}
	/*
	 * public void obtenerIP() {
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese primer octeto: ");
		Pocteto = s.nextLine();
		System.out.println("Ingrese segundo octeto: ");
		Socteto = s.nextLine();
		System.out.println("Ingrese tercer octeto: ");
		Tocteto = s.nextLine();
		System.out.println("Ingrese cuarto octeto: ");
		Cocteto = s.nextLine();
	}
	*/
	
	@Override
	public String toString() {
		return oct1 + "." + oct2 + "." + oct3 + "." + oct4;
	}
	public IP DireccionRed() {
		IP Dred = new IP(0,0,0,0);
		Dred.oct4 = 0;
		Dred.oct1 = oct1;
		Dred.oct2 = oct2;
		Dred.oct3 = oct3;
		return Dred;
	}
	
	
	
}

