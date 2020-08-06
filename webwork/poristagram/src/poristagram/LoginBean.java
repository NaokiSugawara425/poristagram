package poristagram;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.NamingException;

//ユーザー名とパスワードをまとめて取り扱うクラス
public class LoginBean implements Serializable{
	private int u_id;		//ユーザー名
	private String u_pass="";		//パスワード
	private String u_intro="";	//自己紹介
	private Date u_birth= new Date()	;	//誕生日
	private String u_jender="";	//性別
	private String u_age=""	;	//年齢
	private String u_icon=""	;	//サムネイル
	private Date u_signin= new Date()	;	//登録日
	private String u_name=""	;	//表示名



	public int getu_id() {
		return u_id;
	}
	public void setu_id(int u_id) {
		this.u_id = u_id;
	}
	public String getu_pass() {
		return u_pass;
	}
	public void setu_pass(String u_pass) {
		this.u_pass = u_pass;
	}

	public String getu_intro() {
		return u_intro;
	}
	public void setu_intro(String u_intro) {
		this.u_intro = u_intro;
	}
	public Date getu_birth() {
		return u_birth;
	}
	public void setu_birth(Date u_birth) {
		this.u_birth = u_birth;
	}
	public String getu_jender() {
		return u_jender;
	}
	public void setu_jender(String u_jender) {
		this.u_jender = u_jender;
	}
	public String getu_age() {
		return u_age;
	}
	public void setu_age(String u_age) {
		this.u_age = u_age;
	}
	public String getu_icon() {
		return u_icon;
	}
	public void setu_icon(String u_icon) {
		this.u_icon = u_icon;
	}
	public Date getu_signin() {
		return u_signin;
	}
	public void setu_signin(Date u_signin) {
		this.u_signin = u_signin;
	}
	public String getu_name() {
		return u_name;
	}
	public void setu_name(String u_name) {
		this.u_name = u_name;
	}

	public LoginBean login(String u_name) throws SQLException, NamingException

		{

		String id = u_name;

			//使用するクラスのインスタンス化
			Connection conn=null;
			Statement st=null;
			ResultSet rs=null;
			LoginBean loginbean=null;

		//例外処理
			try{
			// コネクションにリソースファインダークラスの
			// インスタンスのメソッドを使用し設定
			conn=new ResourceFinder().getConnection();

			// ステートメントをコネクションクラスのメソッドを利用し、ＳＱＬ文を格納できるようにする
			st=conn.createStatement();

			//SQL分格納
			rs=st.executeQuery("SELECT * FROM user where u_name ='"+ id +"';");

			// 最初にカーソルを1個ずらす
			// カーソルをずらした先にデータがなければ終了

			while (rs.next())
			{

				// LoginBeanのインスタンス化
				loginbean = new LoginBean();

				// LoginBeanのオブジェクトにフィールドをセット
				loginbean.setu_id(rs.getInt("u_id"));
				loginbean.setu_pass(rs.getString("u_pass"));
				loginbean.setu_intro(rs.getString("u_intro"));
				loginbean.setu_birth(rs.getDate("u_birth"));
				loginbean.setu_jender(rs.getString("u_jender"));
				loginbean.setu_age(rs.getString("u_age"));
				loginbean.setu_icon(rs.getString("u_icon"));
				loginbean.setu_signin(rs.getDate("u_signin"));
				loginbean.setu_name(rs.getString("u_name"));
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
			return loginbean;
	}


	public static ArrayList<LoginBean> alluser() throws SQLException, NamingException
	{

		// アレイリストの宣言
		ArrayList<LoginBean> list = new ArrayList<LoginBean>();

		//使用するクラスのインスタンス化
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		LoginBean loginbean=null;

		//例外処理
		try{
			// コネクションにリソースファインダークラスの
			// インスタンスのメソッドを使用し設定
			conn=new ResourceFinder().getConnection();

			// ステートメントをコネクションクラスのメソッドを利用し、ＳＱＬ文を格納できるようにする
			st=conn.createStatement();

			//SQL分格納
			rs=st.executeQuery("SELECT u_name,u_pass FROM user");

			// 最初にカーソルを1個ずらす
			// カーソルをずらした先にデータがなければ終了
			while (rs.next())
			{
				// LoginBeanのインスタンス化
				loginbean = new LoginBean();

				// LoginBeanのオブジェクトにフィールドをセット
				loginbean.setu_name(rs.getString("u_name"));
				loginbean.setu_pass(rs.getString("u_pass"));

				// アレイリストに追加
				list.add(loginbean);
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

	public void saveAccount(String id, String pass){
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
			st = conn.prepareStatement("insert into user(u_name,u_pass) values(?,?)");

			st.setString(1,id);
			st.setString(2,pass);

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

	public void UpdateProfile (ArrayList<Object> list, int id){

		//String str0 = (String)list.get(0);;
		String str1 = (String)list.get(1);
		String str2 = (String)list.get(2);
		String str3 = (String)list.get(3);
		String str4 = (String)list.get(4);
		int age = Integer.parseInt((String)list.get(5));
		String str6 = (String)list.get(6);
		String str7 = (String)list.get(7);

		//使用するクラスのインスタンス化
		Connection conn=null;
		Statement st=null;


		//例外処理
		try{
			// コネクションにリソースファインダークラスの
			// インスタンスのメソッドを使用し設定
			conn=new ResourceFinder().getConnection();

			// ステートメントをコネクションクラスのメソッドを利用し、ＳＱＬ文を格納できるようにする
			st=conn.createStatement();

			//SQL分格納
			int num = st.executeUpdate("update user set u_name = '" + str1 + "',u_jender = '" + str3 + "',u_age = " + age + ",u_pass = '" + str6 + "',u_icon = '" + str7 + "',u_intro = '" + str2 + "' , u_birth = '" + str4 + "' where u_id = " + id + ";");

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

			st.close();
			conn.close();
			}
			catch(SQLException e)
			{
			// エラー表示
			e.printStackTrace();
			}
		}
	}
}

