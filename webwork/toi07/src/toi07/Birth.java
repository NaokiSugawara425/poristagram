package toi07;

public class Birth
{
	// フィールドの宣言
	private int birthYear = 0;
	private int old = 0;
	private String gen = null;
	private String wareki = null;

	// セットメソッドとゲットメソッド
	// birthYearセット時に同時にwarekiをセット
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
		if (birthYear <= 1911){
			gen = "明治";
			int wa = birthYear - 1900 + 33;
			wareki = gen + wa + "年";
		}else if (birthYear == 1912){
			wareki = "明治45年/大正元年";
		}else if (1913 <= birthYear && birthYear <= 1925){
			gen = "大正";
			int wa = birthYear - 1911;
			wareki = gen + wa + "年";
		}else if (birthYear == 1926){
			wareki = "明治15年/昭和元年";
		}else if (1927 <= birthYear && birthYear <= 1988){
			gen = "昭和";
			int wa = birthYear - 1925;
			wareki = gen + wa + "年";
		}else if (birthYear == 1989){
			wareki = "昭和64年/平成元年";
		}else if (1990 <= birthYear && birthYear <= 2018){
			gen = "平成";
			int wa = birthYear - 1988;
			wareki = gen + wa + "年";
		}else if (birthYear == 2019){
			wareki = "平成31年/令和元年";
		}else if (2019 <= birthYear ){
			gen = "令和";
			int wa = birthYear - 2018;
			wareki = gen + wa + "年";
		}
	}
	public int getBirthYear() {
		return birthYear;
	}

	public void setOld(int old) {
		this.old = old;
	}	public int getOld() {
		return old;
	}

	public String getWareki() {
		return wareki;
	}
	public void setWareki(String wareki) {
		this.wareki = wareki;
	}
}
