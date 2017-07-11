package yzu.shopping.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import yzu.shopping.dao.IGoods;
import yzu.shopping.pojo.Account;
import yzu.shopping.pojo.Category;
import yzu.shopping.pojo.Goods;
import yzu.shopping.util.DBConn;

public class GoodsImpl implements IGoods {

	public List<Goods> queryGiscommendGoods(int cid) {
		// TODO Auto-generated method stub
		List<Goods> goodss = new ArrayList<Goods>();
		Connection connection = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM goods g INNER JOIN category c ON g.cid=c.cid WHERE giscommend='true' AND gisopen='true' AND g.cid=? ORDER by gdate DESC";
		DBConn conns = new DBConn();
		connection = conns.getConnection();
		try {
			pre = connection.prepareStatement(sql);
			pre.setInt(1, cid);
			rs = pre.executeQuery();
			while (rs.next()) {
				Goods goods = new Goods();
				goods.setGid(rs.getInt("gid"));
				goods.setGname(rs.getString("gname"));
				goods.setGdate(rs.getDate("gdate"));
				goods.setGiscommend(rs.getBoolean("giscommend"));
				goods.setGisopen(rs.getBoolean("gisopen"));
				goods.setGprice(rs.getDouble("gprice"));
				goods.setGremark(rs.getString("gremark"));
				goods.setGxremark(rs.getString("gxremark"));
				goods.setGpic(rs.getString("gpic"));
				Category category = new Category();
				category.setCid(rs.getInt("cid"));
				category.setCtype(rs.getString("ctype"));
				category.setChot(rs.getBoolean("chot"));
				goods.setCategory(category);
				goodss.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return goodss;
	}
	
	
	public List<Goods> queryGoods(String gname) {
		// TODO Auto-generated method stub
		List<Goods> goodss = new ArrayList<Goods>();
		Connection connection = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM goods g INNER JOIN category c ON g.cid=c.cid WHERE gname LIKE ?";
		DBConn conns = new DBConn();
		connection = conns.getConnection();
		try {
			pre = connection.prepareStatement(sql);
			pre.setString(1, "%"+gname+"%");
			rs = pre.executeQuery();
			while(rs.next()){
				Goods goods=new Goods();
				goods.setGid(rs.getInt("gid"));
				goods.setGname(rs.getString("gname"));	
				goods.setGdate(rs.getDate("gdate"));
				goods.setGiscommend(rs.getBoolean("giscommend"));
				goods.setGisopen(rs.getBoolean("gisopen"));
				goods.setGprice(rs.getDouble("gprice"));
				goods.setGremark(rs.getString("gremark"));
				goods.setGxremark(rs.getString("gxremark"));
				goods.setGpic(rs.getString("gpic"));
				Category category = new Category();
				category.setCid(rs.getInt("cid"));
				category.setCtype(rs.getString("ctype"));
				category.setChot(rs.getBoolean("chot"));
				goods.setCategory(category);
				goodss.add(goods);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return goodss;
	}

}
