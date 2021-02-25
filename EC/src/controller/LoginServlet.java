package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDao;
import dao.UserDao;
import model.CategoryBean;
import model.UserBean;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		/*.Login.jspの(<p>名前：<input type="text" name = "namae"></p>)
		から値"namae"を取得し、変数nameに格納*/
		String name = request.getParameter("namae");

		/*.Login.jspの(<p>パスワード：<input type="text" name = "pass"></p>)
		から値"password"を取得し、変数passwordに格納*/
		String password = request.getParameter("password");


	     UserBean userBean = new UserBean();



		//.UserDaoのインスタンスを生成
		UserDao userDao = new UserDao();


		userBean = userDao.login(name,password);

		/*if文(条件式)の結果が
		 * true  ➡ Serch.jspに遷移する。
		 * faise ➡ Login.jspでエラーの文章が表示されるようにする。*/

		//条件式 要約 ➡ 初期値じゃなかったら、成功。

		//.equals = (==)の意味。理由➡比較対象が文字列だから
		if(!(userBean.getLoginId().equals("") && userBean.getLoginPw().equals("")) ) {

			//ログインが成功した時点でユーザ情報sessionへログイン情報を渡す
			HttpSession session = request.getSession(true);

			                 //(paramu名,格納したい値)
			session.setAttribute("userinfo",userBean);


			//Category情報が欲しい。
			//CategoryBean型のArrayListを作成、リスト名は「categorylist」
			ArrayList<CategoryBean> categorylist = new ArrayList<CategoryBean>();

			//Jdbcのインスタンスを生成
			CategoryDao categoryDao = new CategoryDao();

			//Jdbcクラスのkensakuメソッド(引数には1で格納したnameを渡す)を呼び出し、uselistに代入する。
			categorylist = categoryDao.category();

			//requestオブジェクトでuselistをセット(パラメーター名は"catInfo")
			request.setAttribute("catInfo", categorylist);

			RequestDispatcher rd = request.getRequestDispatcher("/view/Serch.jsp");
			//簡単にいうと↑文➡ジャンプ先選定。↓文➡飛ぶよっ!!ってこと.by高尾
			rd.forward(request,response);


		}else {
			request.setAttribute("message", "IDまたはパスワードが違います");
			request.getRequestDispatcher("/view/Login.jsp").forward(request, response);



		}




	}

}
