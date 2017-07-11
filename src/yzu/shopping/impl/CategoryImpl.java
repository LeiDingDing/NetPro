package yzu.shopping.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import yzu.shopping.dao.ICategory;
import yzu.shopping.pojo.Account;
import yzu.shopping.pojo.Category;
import yzu.shopping.util.DBConn;

public class CategoryImpl implements ICategory {

	@Override
	public void saveCategory(Category category) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement pre=null;
		String sql="INSERT INTO category VALUES (?,?,?)";
		DBConn conns= new DBConn();
		connection=conns.getConnection();
		try{
			pre=connection.prepareStatement(sql);
			pre.setString(1, category.getCtype());
			pre.setBoolean(2, category.isChot());
			pre.setInt(3, category.getAccount().getAid());
			pre.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	
	
	public List<Category> queryCategory(String ctype) {
		// TODO Auto-generated method stub
		List<Category> categorys=new ArrayList<Category>();
		Connection connection=null;
		PreparedStatement pre=null;
		ResultSet rs=null;
		String sql="SELECT * FROM category c INNER JOIN account a on c.aid=a.aid WHERE ctype LIKE ?";
		DBConn conns= new DBConn();
		connection=conns.getConnection();
		try{
			pre=connection.prepareStatement(sql);
			pre.setString(1, "%"+ctype+"%");
			rs=pre.executeQuery();
			while(rs.next()){
				Category category=new Category();
				category.setCid(rs.getInt("cid"));
				category.setCtype(rs.getString("ctype"));
				category.setChot(rs.getBoolean("chot"));
				Account account=new Account();
				account.setAid(rs.getInt("aid"));
				account.setAlogin(rs.getString("alogin"));
				category.setAccount(account);
				categorys.add(category);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return categorys.size()==0?null:categorys;
		
	}
	
	
	public List<Category> queryCategory(boolean isChot) {
		// TODO Auto-generated method stub
		List<Category> categorys = new ArrayList<Category>();
		Connection connection = null;
		PreparedStatement pre = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM category where chot=?";
		DBConn conns = new DBConn();
		connection = conns.getConnection();
		try {
			pre = connection.prepareStatement(sql);
			pre.setBoolean(1, isChot);
			rs = pre.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setCid(rs.getInt("cid"));
				category.setCtype(rs.getString("ctype"));
				category.setChot(rs.getBoolean("chot"));
				categorys.add(category);
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
		return categorys;
	}
}
