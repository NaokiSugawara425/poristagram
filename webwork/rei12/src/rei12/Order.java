package rei12;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

//セミナーの参加人数とかを管理するクラス
public class Order implements Serializable
{
	// フィールドの宣言
	private int orderNinzu;
	private String seminar = null;

	// ゲッター、セッターメソッド
	public int getOrderNinzu() {
		return orderNinzu;
	}
	public String getSeminar() {
		return seminar;
	}
	public void setOrderNinzu(int orderninzu) {
		this.orderNinzu = orderninzu;
	}
	public void setSeminar(String seminar) {
		this.seminar = seminar;
	}

	// データを挿入するというメソッド、引数アレイリストOrder型
	public static void insertData(ArrayList<Order> orderList)
	{
		// 使用するクラスのインスタンス化
		Connection conn = null;
		Order order = null;
		PreparedStatement st = null;

		// 例外処理
		try
		{
			// コネクションにリソースファインダークラスの
			// インスタンスのメソッドを使用し設定
			conn = new ResourceFinder().getConnectionPUser();

			// ステートメントをコネクションクラスのメソッドを利用し、
			// ＳＱＬ文を格納
			st = conn.prepareStatement("insert into t_order(seminar, orderNinzu) values(?,?)");

			// オーダーリストのデータ数だけ繰り返し
			for (int i = 0; i < orderList.size(); i++)
			{
				// オーダーリストからOrder型のオブジェクトを取り出す
				order = (Order)orderList.get(i);

				// ステートメントに格納されているSQL文の？のところに
				// オブジェクトのデータを付与
				// 一個目の？
				st.setString(1, order.getSeminar());

				// 二個目の？
				st.setInt(2, order.getOrderNinzu());

				// データの更新(追加)
				st.executeUpdate();

				// いったん変数stを初期化
				st.clearParameters();
			}
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
}
