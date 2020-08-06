package rensyu03;

public class Order
{
	// フィールドの宣言
	private int number;
	private String syohin = null;

	public int getNumber() {
		return number;
	}
	public String getSyohin() {
		return syohin;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setSyohin(String syohin) {
		this.syohin = syohin;
	}
}
