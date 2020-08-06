package rei07;

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
@WebServlet("/Rei07Controller")

public class Rei07Controller extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		Rei07Bean rei07bean = new Rei07Bean();
		rei07bean.setText01(request.getParameter("text01"));
		request.setAttribute("rei07bean",rei07bean);

		ServletContext context=getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/rei07_response.jsp");
		rd.forward(request, response);
	}
}

