package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.ProductBean;

public class ProductDao {

	//パターン1のメソッド
	public ArrayList<ProductBean> kensaku() {

		ArrayList<ProductBean> productList = new ArrayList<ProductBean>();

		String url = "jdbc:mysql://localhost/ec";
		String id = "root";
		String pass = "password";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pass);
			//ステートメント宣言。
			stmt = conn.createStatement();
			String sql = "select * from product";

			//rsに実行結果を入れる。 executeQuery();＝セレクト文の実行。
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ProductBean productBean = new ProductBean();
				productBean.setProCd(rs.getInt("pro_cd"));
				productBean.setProName(rs.getString("pro_name"));
				productBean.setStockNo(rs.getInt("stock_no"));
				productBean.setProPrice(rs.getInt("pro_price"));
				productBean.setCatId(rs.getInt("cat_id"));
				productBean.setProImg(rs.getString("pro_img"));
				productBean.setProMsg(rs.getString("pro_msg"));

				productList.add(productBean);
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
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productList;
	}

	//パターン2のメソッド
	public ArrayList<ProductBean> kensaku(String name) {

		ArrayList<ProductBean> productList = new ArrayList<ProductBean>();

		String url = "jdbc:mysql://localhost/userdb";
		String id = "root";
		String pass = "password";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pass);

			//引数で取ってきた値が含まれているものを全カラム取得する
			String sql = "select * from product where pro_name like ?";

			pstmt = conn.prepareStatement(sql);

			//「%」は0文字以上の任意の文字列にマッチします。
			//参考URL : https://www.dbonline.jp/mysql/select/index7.html
			pstmt.setString(1, "%" + name + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductBean productBean = new ProductBean();
				productBean.setProCd(rs.getInt("pro_cd"));
				productBean.setProName(rs.getString("pro_name"));
				productBean.setStockNo(rs.getInt("stock_no"));
				productBean.setProPrice(rs.getInt("pro_price"));
				productBean.setCatId(rs.getInt("cat_id"));
				productBean.setProImg(rs.getString("pro_img"));
				productBean.setProMsg(rs.getString("pro_msg"));

				productList.add(productBean);
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
		return productList;
	}

	//パターン3のメソッド
	public ArrayList<ProductBean> kensaku(int categoryId) {

		ArrayList<ProductBean> productList = new ArrayList<ProductBean>();

		String url = "jdbc:mysql://localhost/userdb";
		String id = "root";
		String pass = "password";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pass);

			//引数で取ってきた値が含まれているものを全カラム取得する
			//like "%" キーワード専用の文言。
			String sql = "select * from product where cat_id = ?";

			pstmt = conn.prepareStatement(sql);

			//「%」は0文字以上の任意の文字列にマッチします。
			//参考URL : https://www.dbonline.jp/mysql/select/index7.html
			pstmt.setInt(1, categoryId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductBean productBean = new ProductBean();
				productBean.setProCd(rs.getInt("pro_cd"));
				productBean.setProName(rs.getString("pro_name"));
				productBean.setStockNo(rs.getInt("stock_no"));
				productBean.setProPrice(rs.getInt("pro_price"));
				productBean.setCatId(rs.getInt("cat_id"));
				productBean.setProImg(rs.getString("pro_img"));
				productBean.setProMsg(rs.getString("pro_msg"));

				productList.add(productBean);
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
		return productList;
	}

	//パターン4のメソッド
	public ArrayList<ProductBean> kensaku(String name , int categoryId) {

		ArrayList<ProductBean> productList = new ArrayList<ProductBean>();

		String url = "jdbc:mysql://localhost/userdb";
		String id = "root";
		String pass = "password";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pass);

			//引数で取ってきた値が含まれているものを全カラム取得する
			String sql = "select * from product where pro_name like ? and cat_id = ?";

			pstmt = conn.prepareStatement(sql);

			//「%」は0文字以上の任意の文字列にマッチします。
			//参考URL : https://www.dbonline.jp/mysql/select/index7.html
			pstmt.setString(1, "%" + name + "%");
			pstmt.setInt(2, categoryId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductBean productBean = new ProductBean();
				productBean.setProCd(rs.getInt("pro_cd"));
				productBean.setProName(rs.getString("pro_name"));
				productBean.setStockNo(rs.getInt("stock_no"));
				productBean.setProPrice(rs.getInt("pro_price"));
				productBean.setCatId(rs.getInt("cat_id"));
				productBean.setProImg(rs.getString("pro_img"));
				productBean.setProMsg(rs.getString("pro_msg"));

				productList.add(productBean);
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
		return productList;
	}
}
