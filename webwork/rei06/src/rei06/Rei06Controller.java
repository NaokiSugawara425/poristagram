package rei06;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Rei06Controller
 */
@WebServlet("/Rei06Controller")

public class Rei06Controller extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		Rei06Bean rei06bean = new Rei06Bean();
		rei06bean.setText01(request.getParameter("text01"));
		request.setAttribute("rei06bean",rei06bean);

		ServletContext context=getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/rei06_response.jsp");
		rd.forward(request, response);
	}
}

