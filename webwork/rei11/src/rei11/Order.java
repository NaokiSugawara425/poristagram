package rei11;

// セミナーの参加人数とかを管理するクラス
public class Order implements java.io.Serializable
{
	// フィールドの宣言
	private int orderNinzu;
	private String seminar = null;

	// ゲッター、セッターメソッド
	public int getOrderNinzu() {
		return orderNinzu;
	}
	public String getSeminar() {
		return seminar;
	}
	public void setOrderNinzu(int orderninzu) {
		this.orderNinzu = orderninzu;
	}
	public void setSeminar(String seminar) {
		this.seminar = seminar;
	}
}
