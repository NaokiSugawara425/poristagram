package toi06ex;

import java.io.Serializable;

// 円クラス
public class Circle implements Serializable {

	// フィールドの宣言
	private double hankei;
	private double tyokkei;
	private double ensyu;
	private double menseki;

	// 半径のセットメソッド
	// 同時に他のフィールドもセット
	public void setCir(double r)
	{
		this.hankei = r;
		tyokkei = 2 * hankei;
		ensyu = 2 * Math.PI * hankei;
		menseki = Math.PI * hankei * hankei;
	}

	// 半径のゲットメソッド
	public Double getHankei()
	{
		return hankei;
	}

	// 直径のゲットメソッド
	public Double getTyokkei()
	{
		return tyokkei;
	}

	// 円周のゲットメソッド
	public double getEnsyu()
	{
		return ensyu;
	}

	// 面積のゲットメソッド
	public Double getMenseki()
	{
		return menseki;
	}
}
