package toi06_2;

import java.io.Serializable;

public class Circle implements Serializable {
	private double hankei;
	private double tyokkei;
	private double ensyu;
	private double menseki;

	public void setCir(double r) {
		this.hankei = r;
	}
	public Double getHankei() {
		return hankei;
	}
	public Double getTyokkei(){
		tyokkei = 2 * hankei;
		return tyokkei;
	}
	public double getEnsyu(){
		ensyu = 2 * Math.PI * hankei;
		return ensyu;
	}
	public Double getMenseki(){
		menseki = Math.PI * hankei * hankei;
		return menseki;
	}
}
