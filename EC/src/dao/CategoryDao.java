package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.CategoryBean;

public class CategoryDao {
	//メソッド作成。
	/*戻り値の型 メソッド名（引数リスト） {
	実行したい処理
	}*/

	public ArrayList<CategoryBean> category() {

		ArrayList<CategoryBean> categoryList = new ArrayList<CategoryBean>();

		String url = "jdbc:mysql://localhost/ec";
		String id = "root";
		String pass = "password";
		Connection conn = null;
      //後術のselect文で「?」を使わないのでステートメントを使う。
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pass);
			//ステートメント宣言。
			stmt = conn.createStatement();
			String sql = "select * from category";

			//rsに実行結果を入れる。 executeQuery();＝セレクト文の実行。
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				//while文使用時、ﾃﾞｰﾀ上書き防止の為、最初にｲﾝｽﾀﾝｽ化を行う。
				CategoryBean categoryBean = new CategoryBean();

				categoryBean.setCatId(rs.getInt("cat_id"));
				categoryBean.setCatName(rs.getString("cat_name"));
				categoryList.add(categoryBean);

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
		return categoryList;
	}
}
