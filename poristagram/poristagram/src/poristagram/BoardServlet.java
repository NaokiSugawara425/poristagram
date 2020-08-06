package poristagram;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //リスナークラスに移動したい
        request.setCharacterEncoding("UTF-8");

        // 既存のコメントを確認
        FindCommentLogic fcl = new FindCommentLogic();
        List<Board> list = fcl.executeFindComment();

        // セッションスコープにコメントリストを保存
        HttpSession session = request.getSession();
        session.setAttribute("listAttribute", list);

        RequestDispatcher rd =request.getRequestDispatcher("/jsp/chat.jsp");
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // 入力された値を取得
        int id = Integer.parseInt(request.getParameter("id").trim());
        int toid = Integer.parseInt(request.getParameter("toid").trim());
        int cid = Integer.parseInt(request.getParameter("cid").trim());


        String name = request.getParameter("name");
        String toname = request.getParameter("toname");
        String comment = request.getParameter("comment");

        //JavaBeansに格納
        Board bo = new Board();
        bo.setId(id);
        bo.setToid(toid);
        bo.setCid(id, toid );
        bo.setName(name);
        bo.setToname(toname);
        bo.setComment(comment);

        // mysqlに格納
        AddCommentLogic acl = new AddCommentLogic();
        acl.executeAddComment(bo);

        // 今入力されたコメントと既存のコメントをmysqlから取得
        FindCommentLogic fcl = new FindCommentLogic();
        List<Board> list = fcl.executeFindComment();

        Board b = new Board();
        int rireki = 0;

		try {
			 rireki = b.countData(name, toname);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		boolean boo =true;
		if (rireki == 0){
			boo = false;
		}else{
			boo = true;
		}


		b.setRireki(boo);



		request.setAttribute("rireki", b);

        // セッションスコープにコメントリストを保存
        HttpSession session = request.getSession();
        session.setAttribute("listAttribute", list);

        RequestDispatcher rd =request.getRequestDispatcher("/jsp/chat.jsp");
        rd.forward(request, response);

    }

}

