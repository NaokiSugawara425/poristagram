package loginapp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");

		// セッションスコープのインスタンス化
		HttpSession session = request.getSession();

		// セッションのでーたを破棄するメソッド
		session.invalidate();

		// コンテキストのインスタンス化
		ServletContext context = getServletContext();

		// リクエストディスパッチャーのインスタンス化
		// 引数にフォワード先のパスを設定
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/logout.jsp");

		// 転送する、(実行しているのはコントローラ)
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
