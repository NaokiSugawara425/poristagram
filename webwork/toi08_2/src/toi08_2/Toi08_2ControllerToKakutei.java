package toi08_2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Toi08_2ControllerToKakutei")
public class Toi08_2ControllerToKakutei extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");

		// 会社名をいったん文字列型に保存
		String str1 = request.getParameter("company");

		// 住所をいったん文字列型変数に保存
		String str2 = request.getParameter("address");

		// リクエストスコープに登録
		request.setAttribute("company", str1);
		request.setAttribute("address", str2);

		// コンテキストのインスタンス化
		ServletContext context = getServletContext();

		// リクエストディスパッチャーのインスタンス化
		// 引数に転送先のパスを設定
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/kakutei.jsp");

		// 転送する
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
