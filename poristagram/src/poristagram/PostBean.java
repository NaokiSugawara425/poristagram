package poristagram;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PostBean implements Serializable {
	private int p_id = 0;
	private String p_user = "";
	private String p_date = "";
	private String p_text = "";
	private String p_img = "";
	private String p_tag1 = "";
	private String p_tag2 = "";
	private String p_tag3 = "";
	private String p_tag4 = "";

	public int getP_id() {
		return p_id;
	}
	public String getP_user() {
		return p_user;
	}
	public String getP_date() {
		return p_date;
	}
	public String getP_text() {
		return p_text;
	}
	public String getP_img() {
		return p_img;
	}
	public String getP_tag1() {
		return p_tag1;
	}
	public String getP_tag2() {
		return p_tag2;
	}
	public String getP_tag3() {
		return p_tag3;
	}
	public String getP_tag4() {
		return p_tag4;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public void setP_user(String p_user) {
		this.p_user = p_user;
	}
	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
	public void setP_text(String p_text) {
		this.p_text = p_text;
	}
	public void setP_img(String p_img) {
		this.p_img = p_img;
	}
	public void setP_tag1(String p_tag1) {
		this.p_tag1 = p_tag1;
	}
	public void setP_tag2(String p_tag2) {
		this.p_tag2 = p_tag2;
	}
	public void setP_tag3(String p_tag3) {
		this.p_tag3 = p_tag3;
	}
	public void setP_tag4(String p_tag4) {
		this.p_tag4 = p_tag4;
	}

	public PostBean makePost(ArrayList<String> list) throws SQLException
	{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		int id = 0;
		String name = list.get(0);

		try
		{
			//DB接続
			conn = new ResourceFinder().getConnection();
			//stにSQL文を準備・実行
			st = conn.prepareStatement("SELECT * FROM post WHERE p_user = '" + name + "'");
			//rsに実行結果を格納
			rs = st.executeQuery();
			//一行ずらす
			rs.next();
			//toukousuへ結果を格納
			id = (rs.getInt(1));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				//クローズ処理
				rs.close();
				st.close();
				conn.close();
			}
			catch(SQLException e)
			{
				throw e;
			}
		}

		PostBean postbean = new PostBean();

		postbean.setP_id(id);
		postbean.setP_user(list.get(0));
		postbean.setP_img(list.get(1));
		postbean.setP_text(list.get(2));
		postbean.setP_tag1(list.get(3));
		postbean.setP_tag2(list.get(4));
		postbean.setP_tag3(list.get(5));
		postbean.setP_tag4(list.get(6));

		return postbean;
	}

	// データを挿入するというメソッド、引数アレイリストOrder型
	public static void insertData(PostBean toukou)
	{
		// 使用するクラスのインスタンス化
		Connection conn = null;
		PreparedStatement st = null;

		// 例外処理
		try
		{
			// コネクションにリソースファインダークラスの
			// インスタンスのメソッドを使用し設定
			conn = new ResourceFinder().getConnection();

			// ステートメントをコネクションクラスのメソッドを利用し、
			// ＳＱＬ文を格納
			st = conn.prepareStatement("insert into post(p_user,p_text,p_img,p_tag1,p_tag2,p_tag3,p_tag4) values(?,?,?,?,?,?,?)");

			st.setString(1,toukou.p_user);
			st.setString(2,toukou.p_text);
			st.setString(3,toukou.p_img);
			st.setString(4,toukou.p_tag1);
			st.setString(5,toukou.p_tag2);
			st.setString(6,toukou.p_tag3);
			st.setString(7,toukou.p_tag4);

				st.executeUpdate();

				// いったん変数stを初期化
				st.clearParameters();
		}
		catch (Exception e)
		{
			// エラー表示
			e.printStackTrace();
		}
		finally
		{
			try
			{
				// ファイルクローズ
				st.close();
				conn.close();
			}
			catch(Exception ex)
			{
			}
		}
	}

	public int countData(String u_name) throws SQLException{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		int toukou = 0;
		String name = u_name;

		try {
			//DB接続
			conn = new ResourceFinder().getConnection();
			//stにSQL文を準備・実行
			st = conn.prepareStatement("SELECT COUNT(p_id) FROM post WHERE p_user = '" + name + "'");
			//rsに実行結果を格納
			rs = st.executeQuery();
			//一行ずらす
			rs.next();
			//toukousuへ結果を格納
			toukou = (rs.getInt(1));
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try{
				//クローズ処理
				rs.close();
				st.close();
				conn.close();
			}catch(SQLException e){
				throw e;
			}
		}
		return toukou;

	}

	public void saveImage(String imagepath, String user){

		// 使用するクラスのインスタンス化
		Connection conn = null;
		PreparedStatement st = null;
		// 例外処理
		try
		{
			// コネクションにリソースファインダークラスの
			// インスタンスのメソッドを使用し設定
			conn = new ResourceFinder().getConnection();

			// ステートメントをコネクションクラスのメソッドを利用し、
			// ＳＱＬ文を格納
			st = conn.prepareStatement("insert into post(p_img,p_user) values(?,?)");

			st.setString(1,imagepath);
			st.setString(2,user);

			st.executeUpdate();

			// いったん変数stを初期化
			st.clearParameters();
		}
		catch (Exception e)
		{
			// エラー表示
			e.printStackTrace();
		}
		finally
		{
			try
			{
				// ファイルクローズ
				st.close();
				conn.close();
			}
			catch(Exception ex)
			{
			}
		}

	}

	public void saveComment(List<String> list) {
		// TODO 自動生成されたメソッド・スタブ
		// 使用するクラスのインスタンス化
		Connection conn = null;
		PreparedStatement st = null;
		// 例外処理
		try
		{
			// コネクションにリソースファインダークラスの
			// インスタンスのメソッドを使用し設定
			conn = new ResourceFinder().getConnection();

			// ステートメントをコネクションクラスのメソッドを利用し、
			// ＳＱＬ文を格納
			st = conn.prepareStatement("insert into post(p_user, p_img,p_text,p_tag1,p_tag2,p_tag3,p_tag4) values(?,?,?,?,?,?,?);");

			st.setString(1,(String)list.get(0));
			st.setString(2,(String)list.get(1));
			st.setString(3,(String)list.get(2));
			st.setString(4,(String)list.get(3));
			st.setString(5,(String)list.get(4));
			st.setString(6,(String)list.get(5));
			st.setString(7,(String)list.get(6));


			st.executeUpdate();

			// いったん変数stを初期化
			st.clearParameters();
		}
		catch (Exception e)
		{
			// エラー表示
			e.printStackTrace();
		}
		finally
		{
			try
			{
				// ファイルクローズ
				st.close();
				conn.close();
			}
			catch(Exception ex)
			{
			}
		}
	}

	public static ArrayList<PostBean> getPostAll(){
		ArrayList<PostBean> list = new ArrayList<PostBean>();
		PostBean postbean = new PostBean();
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
			rs=st.executeQuery("SELECT * FROM post order by p_id desc");

			// 最初にカーソルを1個ずらす
			// カーソルをずらした先にデータがなければ終了
			while (rs.next())
			{
				// LoginBeanのインスタンス化
				postbean = new PostBean();

				// LoginBeanのオブジェクトにフィールドをセット
				postbean.setP_user(rs.getString("p_user"));
				postbean.setP_img(rs.getString("p_img"));
				postbean.setP_text(rs.getString("p_text"));

				// アレイリストに追加
				list.add(postbean);
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

		return list;
	}

	public static ArrayList<PostBean> getPostAll(String name){
		ArrayList<PostBean> list = new ArrayList<PostBean>();
		PostBean postbean = new PostBean();
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
			rs=st.executeQuery("SELECT * FROM post  where p_user = '" + name + "' order by p_id desc");

			// 最初にカーソルを1個ずらす
			// カーソルをずらした先にデータがなければ終了
			while (rs.next())
			{
				// LoginBeanのインスタンス化
				postbean = new PostBean();

				// LoginBeanのオブジェクトにフィールドをセット
				postbean.setP_user(rs.getString("p_user"));
				postbean.setP_img(rs.getString("p_img"));
				postbean.setP_text(rs.getString("p_text"));

				// アレイリストに追加
				list.add(postbean);
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

		return list;
	}
}


