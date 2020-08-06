package loginapp_2;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// 処理に必要なプログラムを見つけるクラス
public class ResourceFinder
{
	// データを宣言
	private static DataSource dataSource = null;

	// コネクションクラスのインスタンスを返すメソッドを定義
	public Connection getConnection() throws SQLException, NamingException
	{
		// 条件分岐
		if (dataSource == null)
		{
			try
			{
				// dataSourceがnullだったら
				// コンテキストをインスタンス化
				Context context = new InitialContext();

				// データソースに探しに行く先を設定
				// コンテキストタグの中のリソースタグを見に行く
				// ユーザー名、パスワード、IPアドレスを取得
				dataSource = (DataSource)context.lookup("java:comp/env/mylinkLogin");
			}
			catch (NamingException e)
			{
				// エラーメッセージ表示
				// NamingExceptionが発生したらSQLException
				// にして表示
				throw new SQLException(e.getMessage());
			}
		}

		// データソースからコネクションを返す
		return (dataSource.getConnection());
	}
}
