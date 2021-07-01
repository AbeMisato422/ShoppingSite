package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.dao.ItemDAO;

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/adminupdateservlet"})
public class AdminUpdateServlet extends HttpServlet{

	public void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			//HttpSession session=request.getSession();
			PrintWriter out = response.getWriter();

			try{
				int id =Integer.parseInt(request.getParameter("id"));

				ItemDAO dao=new ItemDAO();
				ItemBean itemBean=dao.getAnItem(id);

				request.setAttribute("itemBean", itemBean);
				request.getRequestDispatcher("../views/admin_update.jsp").forward(request, response);

			}catch (Exception e) {
				e.printStackTrace(out);
			}
	}
}
