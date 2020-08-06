package rei10;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 名前解決のアノテーション
@WebServlet("/Rei10Controller")

// コントローラークラス
public class Rei10Controller extends HttpServlet
{
	// 送られてきたデータをrequestに、送るデータはresponseとして処理するメソッド
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub

		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");

		// Beanファイルに書いてあるクラスのインスタンス化
		Rei10Bean rei10bean = new Rei10Bean();

		// もらってきたデータをオブジェクトのセットメソッドを呼び出しまとめる
		rei10bean.setSei(request.getParameter("sei"));
		rei10bean.setNen(request.getParameter("nen"));
		rei10bean.setMosidoki(request.getParameterValues("mosidoki"));
		rei10bean.setSeminar(request.getParameterValues("seminar"));

		// このオブジェクトのデータに名前を付ける
		request.setAttribute("rei10bean", rei10bean);

		// コンテキストのインスタンス化
		ServletContext context = getServletContext();

		// リクエストディスパッチャーのインスタンス化
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/rei10_response.jsp");

		// 転送する
		rd.forward(request, response);
	}
}
