package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.dao.ItemDAO;

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/unlogintopservlet"})
public class UnloginTopServlet extends HttpServlet{

	public void doGet(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		ItemDAO itemDao = new ItemDAO();
		List<ItemBean> list = null;
		try {
			list = itemDao.getItem();

			request.setAttribute("list", list);

			request.getRequestDispatcher("../views/unlogin_top.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace(out);
		}


	}
}
