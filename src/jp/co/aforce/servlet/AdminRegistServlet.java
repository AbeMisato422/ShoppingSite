package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.dao.ItemDAO;
import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/adminregistservlet"})
public class AdminRegistServlet extends HttpServlet{

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	)throws ServletException, IOException{

		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		Page.header(out);

		String img=request.getParameter("img");
		String itemname=request.getParameter("itemname");
		String Price=request.getParameter("price");
		String Category=request.getParameter("category");

		if(img==""||itemname==""||Price==""||Category=="") {
			String msg="未入力項目があります";
			ItemBean itemBean=new ItemBean();
			itemBean.setMsg(msg);

			itemBean.setImg(img);
			itemBean.setItemName(itemname);

			if (Price!="") {
				int price=Integer.parseInt(Price);
				itemBean.setPrice(price);
			}
			if (Category!="") {
				int category=Integer.parseInt(Category);
				itemBean.setCategoryId(category);

				switch(category) {
				case 1:
					itemBean.setCategory("フルーツ");
					break;
				case 2:
					itemBean.setCategory("ドライフルーツ");
					break;
				case 3:
					itemBean.setCategory("スイーツ");
					break;
				case 4:
					itemBean.setCategory("訳あり商品");
					break;
				}

			}
			session.setAttribute("itemBean", itemBean);
			request.getRequestDispatcher("../views/admin_regist.jsp").forward(request, response);

		}else {
			int price=Integer.parseInt(Price);
			int category=Integer.parseInt(Category);

			try {
				ItemBean itemBean=new ItemBean();
				session.setAttribute("itemBean", itemBean);
				ItemDAO dao=new ItemDAO();
				int line=dao.regist(img, itemname, price, category);

				if(line>0) {
					request.getRequestDispatcher("../views/regist_success.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("../views/regist_error.jsp").forward(request, response);
				}

			}catch(Exception e) {
				request.getRequestDispatcher("../views/regist_error.jsp").forward(request, response);
				//e.printStackTrace(out);
			}

		}

	Page.footer(out);
	}




}

