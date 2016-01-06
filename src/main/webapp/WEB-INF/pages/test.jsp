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
你好
<c:if test="${!empty userList}">
    <table class="table table-bordered table-striped">
        <tr>
            <th>流程数</th>
            <th>产物数量</th>
            <th>制造的时间</th>
            <th>成功率</th>
        </tr>
        <tr>
            <th>${userList.line_num}</th>
            <th>${userList.product_num}</th>
            <th>${userList.industryTime}</th>
            <th>${userList.inventProbablity}</th>
        </tr>
        <tr>
            <th>TYPEID</th>
            <th>发明ID</th>
            <th>需求数量</th>
            <th>。。。</th>
        </tr>
        <c:forEach items="${userList.inventMaterial}" var="invent">
            <tr>
                <td>${invent.typeId}</td>
                <td>${invent.materialTypeId}</td>
                <td>${invent.quantity}</td>
                <td>
                    234
                </td>
            </tr>
        </c:forEach>
        <tr>
            <th>TYPEID</th>
            <th>原材料ID</th>
            <th>原材料数量</th>
            <th>。。。</th>
        </tr>
        <c:forEach items="${userList.productMaterials}" var="material">
            <tr>
                <td>${material.industryactivitymaterialsEntity.typeId}</td>
                <td>${material.industryactivitymaterialsEntity.materialTypeId}</td>
                <td>${material.industryactivitymaterialsEntity.quantity}</td>
                <td>
                    234
                </td>
            </tr>
            <c:if test="${!empty material.bluePrintInfo}">
                <c:forEach items="${material.bluePrintInfo.productMaterials}" var="bpi">
                    <tr>
                        <td>${bpi.industryactivitymaterialsEntity.typeId}</td>
                        <td>${bpi.industryactivitymaterialsEntity.materialTypeId}</td>
                        <td>${bpi.industryactivitymaterialsEntity.quantity}</td>
                        <td>
                            234
                        </td>
                    </tr>

                </c:forEach>

            </c:if>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
