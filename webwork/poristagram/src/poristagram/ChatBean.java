package poristagram;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

public class ChatBean {
	private int c_myid;
	private int c_yourid;
	private int c_id;
	private String c_myname;
	private String c_yourname;
	private String c_comment;
	private String c_time;
	public int getC_myid() {
		return c_myid;
	}
	public int getC_yourid() {
		return c_yourid;
	}
	public int getC_id() {
		return c_id;
	}
	public String getC_myname() {
		return c_myname;
	}
	public String getC_yourname() {
		return c_yourname;
	}
	public String getC_comment() {
		return c_comment;
	}
	public String getC_time() {
		return c_time;
	}
	public void setC_myid(int c_myid) {
		this.c_myid = c_myid;
	}
	public void setC_yourid(int c_yourid) {
		this.c_yourid = c_yourid;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public void setC_myname(String c_myname) {
		this.c_myname = c_myname;
	}
	public void setC_yourname(String c_yourname) {
		this.c_yourname = c_yourname;
	}
	public void setC_comment(String c_comment) {
		this.c_comment = c_comment;
	}
	public void setC_time(String c_time) {
		this.c_time = c_time;
	}

	public ArrayList<ChatBean> getChat(int id) throws SQLException, NamingException
	{

		// アレイリストの宣言
		ArrayList<ChatBean> list = new ArrayList<ChatBean>();

		int cid = id;

		//使用するクラスのインスタンス化
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		ChatBean chatbean=null;

		//例外処理
		try{
		// コネクションにリソースファインダークラスの
		// インスタンスのメソッドを使用し設定
		conn=new ResourceFinder().getConnection();

		// ステートメントをコネクションクラスのメソッドを利用し、ＳＱＬ文を格納できるようにする
		st=conn.createStatement();

		//SQL分格納
		rs=st.executeQuery("SELECT * FROM chat WHERE c_id = '" + cid + "';");

		// 最初にカーソルを1個ずらす
		// カーソルをずらした先にデータがなければ終了

		while (rs.next())
		{

			// LoginBeanのインスタンス化
			chatbean = new ChatBean();

			// LoginBeanのオブジェクトにフィールドをセット
			chatbean.setC_myid(rs.getInt("c_myid"));
			chatbean.setC_yourid(rs.getInt("c_yourid"));
			chatbean.setC_id(rs.getInt("c_id"));
			chatbean.setC_myname(rs.getString("c_myname"));
			chatbean.setC_yourname(rs.getString("c_yourname"));
			chatbean.setC_comment(rs.getString("c_comment"));
			chatbean.setC_time(rs.getString("c_time"));

			list.add(chatbean);
		}

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
		return list;
}
}
