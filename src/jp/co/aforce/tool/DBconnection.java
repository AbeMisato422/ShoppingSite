package jp.co.aforce.tool;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet(urlPatterns= {"/jp.co.aforce.tool/dbconnection"})//
public class DBconnection extends HttpServlet{

	public void doGet(
		HttpServletRequest request, HttpServletResponse response
	)throws ServletException, IOException{

		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
				"java:/comp/env/jdbc/shoppingsite");//
			Connection con=ds.getConnection();

			PreparedStatement st=con.prepareStatement(
				"select * from m_user");//
			ResultSet rs=st.executeQuery();

			while(rs.next()) {//
				out.println(rs.getInt("id"));
				out.println(":");
				out.println(rs.getString("username"));
				out.println(":");
				out.println(rs.getString("password"));
				out.println(":");
				out.println(rs.getString("name"));
				out.println(":");
				out.println(rs.getString("postalcode"));
				out.println(":");
				out.println(rs.getString("address"));
				out.println("<br>");
			}

			 st=con.prepareStatement(
				"select * from m_item");//
			rs=st.executeQuery();

			while(rs.next()) {//
				out.println(rs.getInt("id"));
				out.println(":");
				out.println(rs.getString("img"));
				out.println(":");
				out.println(rs.getString("itemName"));
				out.println(":");
				out.println(rs.getInt("price"));
				out.println(":");
				out.println(rs.getInt("categoryId"));
				out.println("<br>");


			}

			st.close();
			con.close();

		}catch (Exception e) {
			e.printStackTrace(out);

		}
		Page.footer(out);
	}
}
