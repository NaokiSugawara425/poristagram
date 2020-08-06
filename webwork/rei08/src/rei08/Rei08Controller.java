package rei08;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Rei08Controller
 */
@WebServlet("/Rei08Controller")
public class Rei08Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rei08Controller() {
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
	Rei08Bean rei08bean = new Rei08Bean();
	rei08bean.setText01(request.getParameter("text01"));
	request.setAttribute("rei08bean", rei08bean);

	ServletContext context = getServletContext();
	RequestDispatcher rd = context.getRequestDispatcher("/jsp/rei08_response.jsp");
	rd.forward(request, response);
	}

}
