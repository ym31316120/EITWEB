<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/12/31
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
</head>
<body>
<c:if test="${!empty userList}">
    <table class="table table-bordered table-striped">
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>密码</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.marketGroupId}</td>
                <td>${user.marketGroupName}</td>
                <td>${user.description}</td>
                <td>
                    234
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
