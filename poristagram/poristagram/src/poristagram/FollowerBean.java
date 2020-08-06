package poristagram;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FollowerBean {
	private int f_id =0;
	private Date f_date = null;
	private String f_user_id = null;
	private String f_follow = null;
	public int getF_id() {
		return f_id;
	}
	public Date getF_date() {
		return f_date;
	}
	public String getF_user_id() {
		return f_user_id;
	}
	public String getF_follow() {
		return f_follow;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public void setF_date(Date f_date) {
		this.f_date = f_date;
	}
	public void setF_user_id(String f_user_id) {
		this.f_user_id = f_user_id;
	}
	public void setF_follow(String f_follow) {
		this.f_follow = f_follow;
	}

	public int getFollowerNnm(String id){
		int fn = 0;

		//使用するクラスのインスタンス化
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;

		//例外処理
		try{
			// コネクションにリソースファインダークラスの
			// インスタンスのメソッドを使用し設定
			conn=new ResourceFinder().getConnection();

			// ステートメントをコネクションクラスのメソッドを利用し、ＳＱＬ文を格納できるようにする
			st=conn.createStatement();

			//SQL分格納
			rs=st.executeQuery("COUNT u_user_id,u_follow_id FROM follower Where u_user_id = '" + id + "'");

			rs.next();

			fn = rs.getInt(1);
			}
			catch(SQLException e)
			{
				// エラー表示
				e.printStackTrace();
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
					e.printStackTrace();
				}
			}
		// データを持ったオブジェクトを返す
		return fn;
	}
}
