package loginapp_2;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

	public static ArrayList<LoginBean> login() throws SQLException, NamingException
	{
		// アレイリストの宣言
		ArrayList<LoginBean> list = new ArrayList<LoginBean>();

		// 使用するクラスのインスタンス化
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		LoginBean loginBean = null;

		// 例外処理
		try
		{
			// コネクションにリソースファインダークラスの
			// インスタンスのメソッドを使用し設定
			conn = new ResourceFinder().getConnection();

			// ステートメントをコネクションクラスのメソッドを利用し、
			// ＳＱＬ文を格納できるようにする
			st = conn.createStatement();

			// SQL文の格納
			rs = st.executeQuery("SELECT loginName, password FROM t_login");

			// 最初にカーソルを1個ずらす
			// カーソルをずらした先にデータがなければ終了
			while (rs.next())
			{
				// LoginBeanのインスタンス化
				loginBean = new LoginBean();

				// LoginBeanのオブジェクトにフィールドをセット
				loginBean.setLoginName(rs.getString("loginName"));
				loginBean.setPassword(rs.getString("password"));

				// アレイリストに追加
				list.add(loginBean);
			}
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
		return list;
	}
}
