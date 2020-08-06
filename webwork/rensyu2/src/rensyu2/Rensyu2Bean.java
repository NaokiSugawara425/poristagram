package rensyu2;

public class Rensyu2Bean
{
	// アンケート情報のフィールド
	private String use = null;
	private String live = null;
	private String company = null;
	private String[] pcItem = null;
	private String[] infomation = null;

	// それぞれのゲッター、セッターメソッド
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public String getLive() {
		return live;
	}
	public void setLive(String live1, String live2) {
		String tmp = live1 + live2;
		this.live = tmp;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String[] getPcItem() {
		return pcItem;
	}
	public void setPcItem(String[] pcItem) {
		this.pcItem = pcItem;
	}
	public String[] getInfomation() {
		return infomation;
	}
	public void setInfomation(String[] infomation) {
		this.infomation = infomation;
	}

}
