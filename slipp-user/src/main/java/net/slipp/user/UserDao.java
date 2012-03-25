package net.slipp.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.slipp.support.jdbc.ConnectionManager;

public class UserDao {
	public void create(User user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer insertQuery = new StringBuffer();
			insertQuery.append("INSERT INTO USERS VALUES ");
			insertQuery.append("(?, ?, ?, ?, ?)");

			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(insertQuery.toString());
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			pstmt.setBoolean(5, user.isAdmin());

			pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}

			if (con != null) {
				con.close();
			}
		}
	}

	public void update(User user) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer updateQuery = new StringBuffer();
			updateQuery.append("UPDATE USERS SET ");
			updateQuery.append("name=?, email=?");
			updateQuery.append("WHERE userid=? ");

			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(updateQuery.toString());
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getUserId());

			pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}

			if (con != null) {
				con.close();
			}
		}
	}

	public void remove(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			StringBuffer removeQuery = new StringBuffer();
			removeQuery.append("DELETE FROM USERS ");
			removeQuery.append("WHERE userid=? ");

			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(removeQuery.toString());
			pstmt.setString(1, userId);

			pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}

			if (con != null) {
				con.close();
			}
		}
	}

	public User findUser(String userId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer findQuery = new StringBuffer();
			findQuery.append("SELECT ");
			findQuery.append("userId, password, name, email, isAdmin ");
			findQuery.append("FROM USERS ");
			findQuery.append("WHERE userid=? ");

			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(findQuery.toString());
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();

			User user = null;
			if (rs.next()) {
				user = new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"),
						rs.getString("email"), rs.getBoolean("isAdmin"));
			}

			return user;
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	public List<User> findUserList() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			StringBuffer findQuery = new StringBuffer();
			findQuery.append("SELECT ");
			findQuery.append("userid, password, name, email, isAdmin ");
			findQuery.append("FROM USERS");

			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(findQuery.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			rs = pstmt.executeQuery();

			List<User> userList = new ArrayList<User>();
			while (rs.next()) {
				User user = new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"),
						rs.getString("email"), rs.getBoolean("isAdmin"));
				userList.add(user);
			}

			return userList;
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}
}
