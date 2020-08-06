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
 * Servlet implementation class ChatController
 */
@WebServlet("/ChatController")
public class ChatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		request.setCharacterEncoding("UTF-8");

		String u_name = (String)request.getParameter("u_name");

		HttpSession session=request.getSession();

		LoginBean lb = (LoginBean)session.getAttribute("loginuser");

		String myname = lb.getu_name();
		int m = lb.getu_id();

		int y = 0;
		LoginBean  loginuser = new LoginBean();
		try {
			loginuser =  loginuser.login(u_name);
			y = loginuser.getu_id();
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		Board b = new Board();
		b.setCid(m, y);


		ChatBean cb = new ChatBean();

		// アレイリストの宣言
		ArrayList<ChatBean> allchat = new ArrayList<ChatBean>();

		try {
			allchat = cb.getChat(b.getCid());
		} catch (SQLException | NamingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


		if(session.getAttribute("rireki") != null){
			session.removeAttribute("rireki");

		}
		if(session.getAttribute("touser") != null){
			session.removeAttribute("touser");
		}
		request.setAttribute("allchat", allchat);
		session.setAttribute("rireki", b);
		session.setAttribute("touser", loginuser);

		System.out.println("error2");
		// コンテキストのインスタンス化
		ServletContext context = getServletContext();

		// リクエストディスパッチャーのインスタンス化
		// 引数にフォワード先のパスを設定
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/chat.jsp");
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
