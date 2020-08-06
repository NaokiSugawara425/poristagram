package toi07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Toi07Controller
 */
@WebServlet("/Toi07Controller")
public class Toi07Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 文字コードを設定
		request.setCharacterEncoding("UTF-8");

		// リクエストの中からbirthyearという名前のデータを文字列型変数に格納
		String str =request.getParameter("birthyear");

		// 整数を宣言
		int y = 0;

		// 例外処理
		try
		{
			// アレイリストを宣言、格納するのはOrderg型
			ArrayList<Birth> yearAndOld = new ArrayList<Birth>();

			// 現在の年を宣言
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);

			// 文字列を整数型に変換
			y = Integer.parseInt(str);

			if (y < 1900 || year < y)
			{
				// コンテキストのインスタンス化
				ServletContext context = getServletContext();

				// リクエストディスパッチャーのインスタンス化、送り先(エクセプション）を設定
				RequestDispatcher rd = context.getRequestDispatcher("/jsp/toi07_exception.jsp");

				// データを転送
				rd.forward(request, response);

				// プログラムの中断
				return;
			}

			// 繰り返し文
			for (int i = 0; i < year - y + 1; i++)
			{
				// Beanファイルを利用
				// Birthクラスをインスタンス化
				Birth bir = new Birth();

				// 誕生年から1ずつ足して西暦をセット
				bir.setBirthYear(y + i);

				// 年齢を1ずつ足して年齢をセット
				bir.setOld(i);

				// アレイリストに追加
				yearAndOld.add(bir);
			}
			// リクエストにこのオブジェクトのデータを付与、名前"yearAndOld"
			request.setAttribute("yearAndOld", yearAndOld);

			// コンテキストのインスタンス化
			ServletContext context = getServletContext();

			// リクエストディスパッチャーのインスタンス化、送り先(レスポンス）を設定
			RequestDispatcher rd = context.getRequestDispatcher("/jsp/toi07_response.jsp");

			// データを転送
			rd.forward(request, response);

		}
		catch(NumberFormatException e)
		{
			// コンテキストのインスタンス化
			ServletContext context = getServletContext();

			// リクエストディスパッチャーのインスタンス化、送り先(エクセプション）を設定
			RequestDispatcher rd = context.getRequestDispatcher("/jsp/toi07_exception.jsp");

			// データを転送
			rd.forward(request, response);
		}
	}
}
