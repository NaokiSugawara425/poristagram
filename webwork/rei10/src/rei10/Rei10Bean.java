package rei10;

import java.io.Serializable;

// アンケート結果を管理するクラス
public class Rei10Bean implements Serializable
{
	// フィールドの宣言
	// 性別、年齢、知ったきっかけ、セミナー希望
	private String sei = null;
	private String nen = null;
	private String[] mosidoki = null;
	private String[] seminar = null;

	// それぞれのゲットメソッド、セットメソッド
	public String getSei()
	{
		return sei;
	}

	public void setSei(String sei)
	{
		this.sei = sei;
	}

	public String getNen()
	{
		return nen;
	}

	public void setNen(String nen)
	{
		this.nen = nen;
	}

	public String[] getMosidoki()
	{
		return mosidoki;
	}

	public void setMosidoki(String[] mosidoki)
	{
		this.mosidoki = mosidoki;
	}

	public String[] getSeminar()
	{
		return seminar;
	}

	public void setSeminar(String[] seminar)
	{
		this.seminar = seminar;
	}
}
