package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.UserBean;

public class UserDao {
	/*戻り値の型 メソッド名（引数リスト） {
		実行したい処理
		}*/
	public UserBean login (String loginId,String loginPw) {
		UserBean userBean = new UserBean();

	String url = "jdbc:mysql://localhost/ec";
	String id = "root";
	String pass = "password";
	Connection conn = null;

	//後術のselect文で「?」を使うのでプリペアードステーメントを使う・
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, id, pass);

		String sql = "select * from user where login_id = ? and login_pw = ?";

		pstmt = conn.prepareStatement(sql);


    	 pstmt.setString(1,loginId);
    	 pstmt.setString(2,loginPw);

    	 //rsに実行結果を入れる。 executeQuery();＝セレクト文の実行。
    	 rs = pstmt.executeQuery();


    	 if(rs.next()) {


    		 userBean.setUserId(rs.getInt("user_id"));
    		 userBean.setLoginId(rs.getString("login_id"));
    		 userBean.setLoginPw(rs.getString("login_pw"));

    	 }

	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return userBean;
	}
	}

