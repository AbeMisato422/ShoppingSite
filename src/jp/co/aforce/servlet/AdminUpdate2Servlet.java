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

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/adminupdate2servlet"})
public class AdminUpdate2Servlet extends HttpServlet{

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	)throws ServletException, IOException{

		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		Page.header(out);


		String updatename=request.getParameter("updatename");
		String updatePrice=request.getParameter("updateprice");
		String img=request.getParameter("img");
		int id=Integer.parseInt(request.getParameter("id"));

		if(updatename==""||updatePrice=="") {
			String msg="未入力項目があります";
			ItemBean itemBean=new ItemBean();
			itemBean.setMsg(msg);
			itemBean.setItemName(updatename);
			itemBean.setImg(img);
			itemBean.setId(id);
			if (updatePrice!="") {
				int updateprice=Integer.parseInt(updatePrice);
				itemBean.setPrice(updateprice);
			}
			session.setAttribute("itemBean", itemBean);
			request.getRequestDispatcher("../views/admin_update.jsp").forward(request, response);

		}else {
			int updateprice=Integer.parseInt(updatePrice);

			try {

				ItemBean itemBean=new ItemBean();
				session.setAttribute("itemBean", itemBean);
				ItemDAO dao=new ItemDAO();
				int line=dao.update(updatename, updateprice, id);

				if(line>0) {
					request.getRequestDispatcher("../views/update_success.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("../views/update_error.jsp").forward(request, response);
				}

			}catch(Exception e) {
				request.getRequestDispatcher("../views/update_error.jsp").forward(request, response);
				//e.printStackTrace(out);
			}

		}

	Page.footer(out);
	}




}
