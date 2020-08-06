package poristagram;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TouserpageController
 */
@WebServlet("/TouserpageController")
public class TouserpageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TouserpageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		//文字コードの設定
		request.setCharacterEncoding("UTF-8");
		String u_name = request.getParameter("name");

		//LoginBeanのクラス変数を宣言
		LoginBean loginuser= new LoginBean();
		try {
			loginuser =  loginuser.login(u_name);
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		ArrayList<PostBean> postArray = new ArrayList<PostBean>();

		postArray = PostBean.getPostAll(u_name);


		PostBean pb = new PostBean();
		int num = 0;
		try {
			num = pb.countData(u_name);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		String toukousu = String.valueOf(num);

		//セッションスコープをインスタンス化
		HttpSession session=request.getSession();

		request.setAttribute("postArray", postArray);
		request.setAttribute("Utoukousu", toukousu);
		request.setAttribute("userprf", loginuser);
		// コンテキストのインスタンス化
		ServletContext context = getServletContext();



		// リクエストディスパッチャーのインスタンス化
		// 引数にフォワード先のパスを設定
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/user.jsp");

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
