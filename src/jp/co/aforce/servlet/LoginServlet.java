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

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.ItemDAO;
import jp.co.aforce.dao.UserDAO;

@WebServlet(urlPatterns= {"/jp.co.aforce.servlet/loginservlet"})
public class LoginServlet extends HttpServlet{

	public void doPost(
		HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		HttpSession session=request.getSession();
		PrintWriter out = response.getWriter();

		//リクエストパラメータを受け取る
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		String jsp = "../views/login.jsp";

		//会員情報のプロパティ
		UserBean userBean = new UserBean();

		try {
			//ログイン判定
			UserDAO userDao = new UserDAO();
			userBean = userDao.getUser(username, password);

			if(userBean != null) {

				if (username.equals("Administrator")){
					jsp="../views/admin_top.jsp";
				}else {
//ユーザーと管理者で遷移
					jsp="../views/top.jsp";
				}
				ItemDAO itemDao = new ItemDAO();
				List<ItemBean> list = itemDao.getItem();

				request.setAttribute("list", list);
				//for(ItemBean itemBean : list) {
					//out.println(itemBean.getImg());
					//out.println(itemBean.getImg());
					//out.println(itemBean.getImg());
				//}

			}else{
				userBean=new UserBean();
				userBean.setMsg("ユーザー名またはパスワードに誤りがあります。");
				userBean.setUsername(username);
				userBean.setPassword(password);

			}

			session.setAttribute("userBean", userBean);
			request.getRequestDispatcher(jsp).forward(request, response);

		} catch (Exception e) {
			e.printStackTrace(out);

		}
 	}
}
