package toi06ex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Toi06Controller
 */
// 名前解決をするアノテーション
@WebServlet("/toi06Controller")
public class toi06Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// ポスト形式で送ってきてもらう
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 文字コードを設定
		request.setCharacterEncoding("UTF-8");

		// Beanファイルを利用
		// 円クラスをインスタンス化
		Circle cir = new Circle();

		// リクエストの中からtext0１という名前のデータを文字列型変数に格納
		String str =request.getParameter("text01");

		// 実数を宣言
		double r = 0;

		// 例外処理
		try
		{

			// 文字列を実数型に変換
			r = Double.parseDouble(str);

			// 半径を円クラスのオブジェクトにセット
			cir.setCir(r);

			// リクエストにこのオブジェクトのデータを付与、名前cir
			request.setAttribute("cir", cir);

			// コンテキストのインスタンス化
			ServletContext context = getServletContext();

			// リクエストディスパッチャーのインスタンス化、送り先(レスポンス）を設定
			RequestDispatcher rd = context.getRequestDispatcher("/jsp/toi06ex_response.jsp");

			// データを転送
			rd.forward(request, response);

		}
		catch(NumberFormatException e)
		{
			// コンテキストのインスタンス化
			ServletContext context = getServletContext();

			// リクエストディスパッチャーのインスタンス化、送り先(レスポンス）を設定
			RequestDispatcher rd = context.getRequestDispatcher("/jsp/toi06ex_Exception.jsp");

			// データを転送
			rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
