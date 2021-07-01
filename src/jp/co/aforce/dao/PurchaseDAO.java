package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import jp.co.aforce.beans.ItemBean;
import jp.co.aforce.beans.ItemCartBean;

public class PurchaseDAO extends DAO{

	public boolean insert(
		List<ItemCartBean> cart, String username, String postalcode, String address, String payment
	)throws Exception{

		Connection con=getConnection();
		con.setAutoCommit(false);

		for(ItemCartBean item : cart) {

			String sql="insert into t_purchase values(null, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement st;
			st=con.prepareStatement(sql);



			ItemBean itemBean = item.getItemBean();

			st.setInt(1, itemBean.getId());
			st.setString(2, itemBean.getItemName());
			st.setInt(3, itemBean.getPrice());
			st.setInt(4, item.getCount());
			st.setString(5, username);
			st.setString(6, postalcode);
			st.setString(7, address);
			st.setString(8, payment);

			//PurchaseBean purchaseBean = new PurchaseBean();
			//purchaseBean.setStr("A"+str);
			int line=st.executeUpdate();
			st.close();

			if (line!=1) {
				con.rollback();
				con.setAutoCommit(true);
				con.close();
				return false;
			}
		}

		con.commit();
		con.setAutoCommit(true);
		con.close();
		return true;

	}
}
