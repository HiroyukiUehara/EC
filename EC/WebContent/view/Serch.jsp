<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%--EL式ｺｰﾄﾞを使うかどうかの設定。使う➡false、使わない➡true --%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shouhinkensaku</title>
</head>
<body>
	<h1>商品検索</h1>

	<form action="/EC/serch" method="post">

		<%--【課題1】ﾌﾟﾙﾀﾞｳﾝでｶﾃｺﾞﾘｰを全部表示!初期値は"すべて" --%>
		<select name="categoryType">

			<%-- <c:forEach var="格納用のパラメータ名" items="${リストのパラメータ名}">
	反復処理
	</c:forEach> --%>
			<option value="0">すべて</option>
			<c:forEach var="CategoryBean" items="${catInfo}">

               //例："11"←"美容"
<option value="${CategoryBean.catId}">${CategoryBean.catName}</option>


			</c:forEach>


		</select>
		 <input type="text" name="ken"> 
		 <input type="submit"value="検索">

	</form>
</body>
</html>


