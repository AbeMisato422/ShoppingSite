package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/logoutservlet"})
public class LogoutServlet extends HttpServlet{

	public void doPost(
		HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		HttpSession session=request.getSession();
		PrintWriter out = response.getWriter();

		//UserBean userBean = new UserBean();

		try {

			//if(session.getAttribute("userBean") != null) {
				session.removeAttribute("userBean");
				session.removeAttribute("cart");
				session.removeAttribute("list");


			//}

			request.getRequestDispatcher("../views/logout.jsp").forward(request, response);

		}catch(Exception e) {
			e.printStackTrace(out);
		}

	}
}
