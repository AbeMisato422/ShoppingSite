package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.beans.ItemCartBean;
import jp.co.aforce.dao.ItemDAO;
import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/cartaddservlet"})
public class CartAddServlet extends HttpServlet{

	public void doPost(
		HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		Page.header(out);

		String url="../views/cart.jsp";
		try {



			//String img=request.getParameter("img");
			//String itemName=request.getParameter("itemName");
			//int price =Integer.parseInt(request.getParameter("price"));

			HttpSession session=request.getSession();//既存のセッション使うときも、サーブレット、JSPで必要

			int id=Integer.parseInt(request.getParameter("id"));//リクエストパラメータは戻り値String型

			ItemDAO itemDao=new ItemDAO();
			List<ItemBean> list =itemDao.search();
			session.setAttribute("list", list);

			//System.out.println(list);
			@SuppressWarnings("unchecked")//getAttributeメソッドの戻り値はObject型。型変換のため
			List<ItemCartBean> cart =(List<ItemCartBean>)session.getAttribute("cart");

			//ItemDAO itemDao=new ItemDAO();

			if (cart==null) {//nullならカートが未生成、そもそもカートというリストがあるか
				cart=new ArrayList<ItemCartBean>();
				session.setAttribute("cart", cart);//カートのリストを作る
			}

			for(ItemCartBean itemCartBean : cart) {
				if(itemCartBean.getItemBean().getId()==id) {//カート内におなじID存在するなら個数１増やす
					itemCartBean.setCount(itemCartBean.getCount()+1);
					request.getRequestDispatcher(url).forward(request, response);//ifのときしか通らない
					return;
				}
			}

			@SuppressWarnings("unchecked")
			//List<ItemBean>
			List<ItemBean> LIST=(List<ItemBean>)session.getAttribute("list");//これから追加する商品がカート内に存在しない場合
			for(ItemBean item : LIST) {
				if(item.getId()==id) {
					ItemCartBean i = new ItemCartBean();
					i.setItemBean(item);
					i.setCount(1);

					cart.add(i);

				}
			}

			request.getRequestDispatcher(url).forward(request, response);
		}catch(Exception e){
			e.printStackTrace(out);
		}
		Page.footer(out);
	}


}
