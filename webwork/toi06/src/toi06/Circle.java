package toi06;

import java.io.Serializable;

// 円に関するプロパティを設定するクラス
public class Circle implements Serializable {

	// フィールドの宣言
	private double hankei;
	private double tyokkei;
	private double ensyu;
	private double menseki;

	// 半径のsetメソッド、getメソッド
	public void setCir(double r) {
		this.hankei = r;
	}
	public Double getHankei() {
		return hankei;
	}

	// 直径のgetメソッド
	public Double getTyokkei(){
		tyokkei = 2 * hankei;
		return tyokkei;
	}

	// 円周のgetメソッド
	public double getEnsyu(){
		ensyu = 2 * Math.PI * hankei;
		return ensyu;
	}

	// 面積のgetメソッド
	public Double getMenseki(){
		menseki = Math.PI * hankei * hankei;
		return menseki;
	}
}
