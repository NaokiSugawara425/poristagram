package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestController
 */

// Webサーブレットアノテーション
// コンテキストの後ろの名前解決のための記述
@WebServlet("/TestController")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		response.getWriter().append("Served at: ").append(request.getContextPath());

		// 渡されたデータの文字コードの設定
		request.setCharacterEncoding("UTF-8");

		// 文字列型のvalueを宣言
		String nameValue = "value";

		// 送るデータを格納する文字列型変数
		String getValue = "";

		// 上で宣言した名前のデータをリクエストから呼び出して
		// getValueに格納
		getValue = request.getParameter(nameValue);

		// リクエストにデータを付与
		// データ：getValue、名前：test
		request.setAttribute("test",getValue);

		// コンテキストのインスタンス化
		ServletContext context = getServletContext();

		// コンテキストのインスタンスを利用して
		// リクエストディスパッチャーのインスタンス化
		RequestDispatcher rd = context.getRequestDispatcher("/rei03.jsp");

		// リクエストディスパッチャーのインスタンスに
		// 引数を設定しすることにより転送を実行する
		// リクエストに入っているデータをレスポンスに送っている
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
