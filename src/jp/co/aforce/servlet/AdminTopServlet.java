package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/admintopservlet"})
public class AdminTopServlet extends HttpServlet{

		public void doPost(
				HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

				//HttpSession session=request.getSession();
				//PrintWriter out = response.getWriter();

				String transitScreen ="../views/admin_top.jsp";

				if (request.getParameter("buttonName").equals("変更する")) {

					transitScreen = "../views/admin_update.jsp";

				} else if (request.getParameter("buttonName").equals("削除する")) {

					transitScreen = "../views/admin_delete.jsp";

				}

				// 遷移先画面に遷移する
				request.getRequestDispatcher(transitScreen).forward(request, response);

			}



}
