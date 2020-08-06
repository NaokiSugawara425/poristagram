// パッケージの記述
package rei09;

import java.io.Serializable;

// インポート
import javax.servlet.annotation.WebServlet;

// アノテーション
@WebServlet("/Rei09Bean")

// クラスの宣言
public class Rei09Bean implements Serializable
{
	// フィールドの宣言
	private String value1;

	// セットメソッド
	public void setValue1(String val1)
	{
		this.value1 = val1;
	}

	// ゲットメソッド
	public String getValue1()
	{
		return this.value1;
	}
}
