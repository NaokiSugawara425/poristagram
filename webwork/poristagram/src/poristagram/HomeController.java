package poristagram;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Save_accountController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");



		//セッションスコープをインスタンス化
		HttpSession session=request.getSession();

		session.removeAttribute("toukousu");


		LoginBean loginbean= (LoginBean)session.getAttribute("loginuser");
		String u_name = loginbean.getu_name();
		PostBean pb = new PostBean();
		int num =0;
		try {
			num = pb.countData(u_name);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		String toukousu = String.valueOf(num);


		session.setAttribute("toukousu", toukousu);

		// コンテキストのインスタンス化
		ServletContext context=getServletContext();

		// リクエストディスパッチャーのインスタンス化
		// 引数にフォワード先のパスを設定
		RequestDispatcher rd=context.getRequestDispatcher("/jsp/home.jsp");
		// 転送する、(実行しているのはコントローラ)
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
