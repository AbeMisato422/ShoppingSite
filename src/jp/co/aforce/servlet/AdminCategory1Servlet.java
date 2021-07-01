package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.dao.ItemSelectDAO;

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/admincategory1servlet"})
public class AdminCategory1Servlet extends HttpServlet{

	public void doGet(
		HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		ItemSelectDAO dao=new ItemSelectDAO();

		try {
			List<ItemBean> list = dao.getCategory1();
			request.setAttribute("list", list);
			request.getRequestDispatcher("../views/admin_top.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


	}

}
