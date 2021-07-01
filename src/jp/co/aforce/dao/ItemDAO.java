package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.ItemBean;

public class ItemDAO extends DAO{//DAOはデータベースの処理まとめたものだからsessionとかは違うのかも

	public List<ItemBean> getItem() throws Exception{//商品一覧作成
		List<ItemBean> list=new ArrayList<>();

		Connection con=getConnection();
		String sql="select * from m_item";

		PreparedStatement st;
		st=con.prepareStatement(sql);

		ResultSet rs=st.executeQuery();

		while(rs.next()){
			ItemBean itemBean = new ItemBean();
			itemBean.setId(rs.getInt("id"));
			itemBean.setImg(rs.getString("img"));
			itemBean.setItemName(rs.getString("itemName"));
			itemBean.setPrice(rs.getInt("price"));
			//itemBean.setCategoryId(rs.getInt("categoryId"));
			list.add(itemBean);
		}

		st.close();
		con.close();

		return list;
	}

	public ItemBean getAnItem(int id) throws Exception{


		ItemBean itemBean=null;
		Connection con=getConnection();
		String sql="select id, img, itemName, price, categoryId from m_item where id=?";

		PreparedStatement st;
		st=con.prepareStatement(sql);
		st.setInt(1, id);
		ResultSet rs=st.executeQuery();

		while(rs.next()){
			itemBean = new ItemBean();
			itemBean.setId(rs.getInt("id"));
			itemBean.setImg(rs.getString("img"));
			itemBean.setItemName(rs.getString("itemName"));
			itemBean.setPrice(rs.getInt("price"));
			itemBean.setCategoryId(rs.getInt("categoryId"));

		}

		st.close();
		con.close();

		return itemBean;
	}

	public int update(String updatename, int updateprice, int id) throws Exception{

		Connection con=getConnection();
		String sql="update m_item set itemName=?, price=? where id=?";

		PreparedStatement st;
		st=con.prepareStatement(sql);

		st.setString(1, updatename);
		st.setInt(2, updateprice);
		st.setInt(3, id);
		int line=st.executeUpdate();


		st.close();
		con.close();
		return line;
	}

	public int delete(int id)throws Exception{

		Connection con=getConnection();
		String sql="delete from m_item where id=?";

		PreparedStatement st;
		st=con.prepareStatement(sql);

		st.setInt(1, id);
		int line=st.executeUpdate();


		st.close();
		con.close();
		return line;
	}


	public int regist(String img, String itemname, int price, int category) throws Exception{

		Connection con=getConnection();
		String sql="insert into m_item values(NULL,?,?,?,?)";

		PreparedStatement st;
		st=con.prepareStatement(sql);

		st.setString(1, img);
		st.setString(2, itemname);
		st.setInt(3, price);
		st.setInt(4, category);

		int line=st.executeUpdate();


		st.close();
		con.close();
		return line;
	}

	public List<ItemBean> search() throws Exception{

		List<ItemBean> list=new ArrayList<>();

		Connection con=getConnection();
		String sql="select * from m_item";

		PreparedStatement st;
		st=con.prepareStatement(sql);

		ResultSet rs=st.executeQuery();

		while(rs.next()){
			ItemBean itemBean = new ItemBean();
			itemBean.setId(rs.getInt("id"));
			itemBean.setImg(rs.getString("img"));
			itemBean.setItemName(rs.getString("itemName"));
			itemBean.setPrice(rs.getInt("price"));
			itemBean.setCategoryId(rs.getInt("categoryId"));
			list.add(itemBean);

		}

		st.close();
		con.close();

		return list;
	}



}
