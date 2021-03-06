package yzu.shopping.impl;

import yzu.shopping.dao.IUsers;
import yzu.shopping.pojo.Users;
import yzu.shopping.util.DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersImpl implements IUsers {

	public Users queryUsers(Users users) {
		Users temp = null;
		Connection connection = null;
		PreparedStatement pre = null;
		String sql = "SELECT * FROM users WHERE ulogin=? AND upass=?";
		DBConn conns = new DBConn();
		connection = conns.getConnection();
		try {
			pre = connection.prepareStatement(sql);
			pre.setString(1, users.getUlogin());
			pre.setString(2, users.getUpass());
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				temp = new Users();
				temp.setUlogin(rs.getString("ulogin"));
				temp.setUpass(rs.getString("upass"));
				temp.setUname(rs.getString("uname"));
				temp.setUemail(rs.getString("uemail"));
				temp.setUaddress(rs.getString("uaddress"));
				temp.setUphone(rs.getString("uphone"));
				temp.setUid(rs.getInt("uid"));
				temp.setUsex(rs.getString("usex"));
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
		return temp;
	}

}
