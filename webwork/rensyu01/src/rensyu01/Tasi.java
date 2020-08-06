package rensyu01;

import java.io.Serializable;

public class Tasi implements Serializable {
	//変数の定義
	private double t1;
	private double t2;
	private double wa = 0;
	public double getT1() {
		return t1;
	}
	public void setT1(double t1) {
		this.t1 = t1;
	}
	public double getT2() {
		return t2;
	}
	public void setT2(double t2) {
		this.t2 = t2;
	}
	//足し算の結果を取得するgetメソッドの追加
	public double getWa(){
		wa = t1 +t2;
		return wa;
	}
}
