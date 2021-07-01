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
import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.PurchaseDAO;
import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/purchaseservlet"})
public class PurchaseServlet extends HttpServlet{

	public void doPost(
		HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		Page.header(out);

		String url="../views/confirm.jsp";

		HttpSession session=request.getSession();

		String name=request.getParameter("name");
		String postalcode=request.getParameter("postalcode");
		String address=request.getParameter("address");
		String payment=request.getParameter("payment");


		if(postalcode.length() != 8) {
			url="../views/purchase_error.jsp";
			request.getRequestDispatcher(url).forward(request, response);
			return;
		}

			if(postalcode=="" || address==""||payment=="") {

				UserBean userBean = new UserBean();
				userBean.setErrormsg("入力されていない項目があります。");
				userBean.setName(name);
				userBean.setPostalcode(postalcode);
				userBean.setAddress(address);
				userBean.setPayment(payment);

				url="../views/purchase.jsp";
				session.setAttribute("userBean", userBean);
				request.getRequestDispatcher(url).forward(request, response);
				return;


			}else {

				try {



					PurchaseDAO dao=new PurchaseDAO();
					@SuppressWarnings("unchecked")
					List<ItemCartBean> cart=(List<ItemCartBean>)session.getAttribute("cart");
					if(cart==null || !dao.insert(cart, name, postalcode, address, payment)) {
						url="../views/purchase_error.jsp";
						request.getRequestDispatcher(url).forward(request, response);
					}



					//session.removeAttribute("cart");


					request.getRequestDispatcher(url).forward(request, response);

				}catch(Exception e) {
					if(postalcode.length() != 8) {
						url="../views/purchase_error.jsp";
						request.getRequestDispatcher(url).forward(request, response);
						return;
					}
					e.printStackTrace(out);
				}
			}
	}

}
