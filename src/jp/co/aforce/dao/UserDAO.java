package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.UserBean;

public class UserDAO extends DAO{

	//ログイン判定
	public UserBean getUser(String username, String password)throws Exception{
		UserBean userBean=new UserBean();

		Connection con=getConnection();
		String sql="select * from m_user where username=? and password=?";

		PreparedStatement st;
		st=con.prepareStatement(sql);
		st.setString(1, username);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();

		if(rs.next()) {
			userBean.setId(rs.getInt("id"));
			userBean.setUsername(rs.getString("username"));
			userBean.setPassword(rs.getString("password"));
			userBean.setName(rs.getString("name"));
			userBean.setPostalcode(rs.getString("postalcode"));
			userBean.setAddress(rs.getString("address"));
		}else {
			return null;
		}

		st.close();
		con.close();
		return userBean;
	}
}
