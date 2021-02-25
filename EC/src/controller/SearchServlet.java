package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/Search")
public class SearchServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//Search.jspから値"ken"を取得し、変数nameに格納
		String name = request.getParameter("ken");

		//Search.jspから<select name="categoryType">の値"categoryType"を取得し、変数categoryIdに格納
		int categoryId = Integer.parseInt(request.getParameter("categoryType")) ;



		//ProductBean型のArrayListを作成、リスト名は「productlist」
			ArrayList<ProductBean> productlist = new ArrayList<ProductBean>();

		//ProductDaoクラスのインスタンスを生成
			ProductDao productDao = new ProductDao();

		//if文でパターンを分ける。
		//ProductDaoクラスのkensakuメソッド(引数には1で格納したnameを渡す)を呼び出し、productlistに代入する。

			//パターン1➡"ken"=" " かつ "categoryType"=初期値=0
			if(name.equals("") && categoryId == 0 ) {
				productlist = productDao.kensaku();
				//requestオブジェクトでproductlistをセット(パラメーター名は"abc")
				request.setAttribute("productPattern", productlist);
			}
			//パターン2➡"ken"=" "ではなく、かつ"categoryType"=初期値=0
			else if(!(name.equals("")) && categoryId == 0) {
				productlist = productDao.kensaku(name);
				request.setAttribute("productPattern", productlist);
				}

			//パターン3➡"ken"=" " かつ "categoryType"=初期値=0ではない
			else if(name.equals("") && !(categoryId == 0)) {
				productlist = productDao.kensaku(categoryId);
				request.setAttribute("productPattern", productlist);
			}
			//パターン4➡"ken"=" "ではなく、かつ "categoryType"=初期値=0ではない
			else if(!(name.equals("")) && !(categoryId == 0)) {
				productlist = productDao.kensaku(name ,categoryId);
				request.setAttribute("productPattern", productlist);

			}else {

			}

	}

}
