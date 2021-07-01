package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.ItemBean;

public class ItemSelectDAO extends DAO{

	public List<ItemBean> getCategory1() throws Exception{
		List<ItemBean> list = new ArrayList<>();

		Connection con=getConnection();
		String sql="select * from m_item where categoryId=1";

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

	public List<ItemBean> getCategory2() throws Exception{
		List<ItemBean> list = new ArrayList<>();

		Connection con=getConnection();
		String sql="select * from m_item where categoryId=2";

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

	public List<ItemBean> getCategory3() throws Exception{
		List<ItemBean> list = new ArrayList<>();

		Connection con=getConnection();
		String sql="select * from m_item where categoryId=3";

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

	public List<ItemBean> getCategory4() throws Exception{
		List<ItemBean> list = new ArrayList<>();

		Connection con=getConnection();
		String sql="select * from m_item where categoryId=4";

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

	public List<ItemBean> getItemDESC() throws Exception{
		List<ItemBean> list = new ArrayList<>();

		Connection con=getConnection();
		String sql="select * from m_item ORDER BY price DESC";

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

	public List<ItemBean> getItemASC() throws Exception{
		List<ItemBean> list = new ArrayList<>();

		Connection con=getConnection();
		String sql="select * from m_item ORDER BY price ASC";

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

}
