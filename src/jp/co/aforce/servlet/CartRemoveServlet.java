package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.ItemCartBean;

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/cartremoveservlet"})
public class CartRemoveServlet extends HttpServlet{

	@SuppressWarnings("unchecked")
	public void doGet(
		HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		String url="../views/cart.jsp";

		try {
			HttpSession session=request.getSession();

			int id=Integer.parseInt(request.getParameter("id"));

			List<ItemCartBean> cart =(List<ItemCartBean>)session.getAttribute("cart");

			for(ItemCartBean itemCartBean : cart) {
				if(itemCartBean.getItemBean().getId()==id) {
					cart.remove(itemCartBean);
					break;
				}
			}

			request.getRequestDispatcher(url).forward(request, response);
		}catch(Exception e){
			e.printStackTrace(out);
		}

	}
}
