package poristagram;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileOkController
 */
@WebServlet("/ProfileOkController")
public class ProfileOkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileOkController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");

		// 例外処理
		try
		{
			// セッションオブジェクトを宣言
			HttpSession session = request.getSession();

			ArrayList<Object> list = new ArrayList<Object>();
			LoginBean loginbean = new LoginBean();
			loginbean = (LoginBean)session.getAttribute("loginuser");

			String name = request.getParameter("name");

			list.add(request.getParameter("name"));
			list.add(request.getParameter("name"));
			list.add(request.getParameter("intro"));
			list.add(request.getParameter("jender"));
			list.add(request.getParameter("birth"));
			list.add(request.getParameter("age"));
			list.add(request.getParameter("pass"));
			list.add((String)session.getAttribute("path"));

			int id = loginbean.getu_id();

			LoginBean lb = new LoginBean();

			lb.UpdateProfile(list, id);

			session.removeAttribute("loginuser");

			loginbean = loginbean.login(name);

			session.setAttribute("loginuser", loginbean);


		}
		catch(Exception ex)
		{
			// エラー表示
			ex.printStackTrace();
		}

		// コンテキストのインスタンス化
		ServletContext context = getServletContext();

		// リクエストディスパッチャーのインスタンス化
		// 引数にフォワード先のパスを設定
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/kanryou.jsp");

		// 転送する、(実行しているのはコントローラ)
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
