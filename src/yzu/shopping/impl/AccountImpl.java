package yzu.shopping.impl;

import yzu.shopping.dao.IAccount;
import yzu.shopping.pojo.Account;
import yzu.shopping.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountImpl implements IAccount {

	public Account queryAccount(Account account) {
		// TODO Auto-generated method stub
		//用户的实现
		Account temp=null;
		Connection connection=null;
		PreparedStatement pre=null;
		String sql="SELECT * FROM account WHERE alogin=? AND apass=?";
		DBConn conns= new DBConn();
		connection=conns.getConnection();
		try{
			pre=connection.prepareStatement(sql);
			pre.setString(1, account.getAlogin());
			pre.setString(2, account.getApass());
			ResultSet rs=pre.executeQuery();
			if(rs.next()){
				temp=new Account();
				temp.setAid(rs.getInt("aid"));
				temp.setAlogin(rs.getString("alogin"));
				temp.setApass(rs.getString("apass"));
				temp.setAname(rs.getString("aname"));
				
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
		return temp;
	}

}
