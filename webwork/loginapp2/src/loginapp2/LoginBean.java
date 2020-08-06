package loginapp2;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;

// ユーザ名とパスワードのデータをまとめて扱うクラス
public class LoginBean implements Serializable{

	// ユーザ名とパスワードをフィールドとして宣言
	private String loginName = "";
	private String password = "";

	public String getLoginName() {
		return loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public static LoginBean login() throws SQLException, NamingException
	{
		// 使用するクラスのインスタンス化
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		LoginBean loginBean = null;

		// 例外処理
		try
		{
			// LoginBeanのインスタンス化
			loginBean = new LoginBean();

			// コネクションにリソースファインダークラスの
			// インスタンスのメソッドを使用し設定
			conn = new ResourceFinder().getConnection();

			// ステートメントをコネクションクラスのメソッドを利用し、
			// ＳＱＬ文を格納できるようにする
			st = conn.createStatement();

			// SQL分の格納
			rs = st.executeQuery("SELECT loginName, password FROM t_login");

			// カーソル位置を移動
			rs.next();

			// LoginBeanのオブジェクトにフィールドをセット
			loginBean.setLoginName(rs.getString("loginName"));
			loginBean.setPassword(rs.getString("password"));
		}
		catch (SQLException e)
		{
			// エラー表示
			throw e;
		}
		finally
		{
			try
			{
				// ファイルクローズ
				rs.close();
				st.close();
				conn.close();
			}
			catch(SQLException e)
			{
				// エラー表示
				throw e;
			}
		}

		// データを持ったオブジェクトを返す
		return loginBean;
	}
}
