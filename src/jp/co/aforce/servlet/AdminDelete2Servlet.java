package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.ItemDAO;
import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/admindelete2servlet"})
public class AdminDelete2Servlet extends HttpServlet{

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	)throws ServletException, IOException{

		//HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		Page.header(out);

		int id=Integer.parseInt(request.getParameter("id"));

		try {


			ItemDAO dao=new ItemDAO();
			int line=dao.delete(id);

			if(line>0) {
				request.getRequestDispatcher("../views/delete_success.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("../views/delete_error.jsp").forward(request, response);
			}

		}catch(Exception e) {
			request.getRequestDispatcher("../views/delete_error.jsp").forward(request, response);
			//e.printStackTrace(out);
		}



		Page.footer(out);
	}

}





