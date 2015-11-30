<%@ page contentType =" text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>검색</h2>
<form action="${initParam.rootPath}/admin/findByItemId.do" method="post">
물품ID로 찾기
<input type="number" id="itemId" name="itemId" size="25">
<input type="submit" value="찾기">
</form>

<p>

<form action="${initParam.rootPath}/admin/productsByItemName.do" method="post">
품명으로 찾기
<input type="text" id="itemName" name="itemName" size="25">
<input type="submit" value="찾기">
</form>

<p>

<%-- <form action="${initParam.rootPath}/admin/itemAdd.do" method="post">
카테고리로 찾기
<input type="number" id="categoryId" name="categoryId" size="25">
<input type="submit" value="찾기">
</form> --%>
</body>
</html>