package rensyu2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 文字解決のアノテーション
@WebServlet("/Rensyu2Controller")
public class Rensyu2Controller extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");

		// Beanファイルに書いてあるクラスのインスタンス化
		Rensyu2Bean rensyu2Bean = new Rensyu2Bean();

		// もらってきたデータをオブジェクトのセットメソッドを呼び出しまとめる
		rensyu2Bean.setUse(request.getParameter("use"));
		rensyu2Bean.setLive(request.getParameter("live1"),request.getParameter("live2"));
		rensyu2Bean.setCompany(request.getParameter("company"));
		rensyu2Bean.setPcItem(request.getParameterValues("pcItem"));
		rensyu2Bean.setInfomation(request.getParameterValues("infomation"));

		// このオブジェクトのデータに名前を付ける
		request.setAttribute("rensyu2Bean", rensyu2Bean);

		// コンテキストのインスタンス化
		ServletContext context = getServletContext();

		// リクエストディスパッチャーのインスタンス化
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/rensyu2_response.jsp");

		// 転送する
		rd.forward(request, response);
	}
}
