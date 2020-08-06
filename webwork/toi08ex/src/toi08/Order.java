package toi08;

// 商品名とケース数を管理するクラス
public class Order implements java.io.Serializable
{
	// フィールドの宣言
	private int caseNum;
	private String syohin = null;
	private int price;

	// ゲッター、セッターメソッド
	public int getCaseNum() {
		return caseNum;
	}
	public String getSyohin() {
		return syohin;
	}
	public void setCaseNum(int caseNum) {
		this.caseNum = caseNum;
	}
	public void setSyohin(String syohin) {
		this.syohin = syohin;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
