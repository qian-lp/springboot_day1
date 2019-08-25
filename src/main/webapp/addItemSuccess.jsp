<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style type="text/css">
        body {
            background-image: url("${pageContext.request.contextPath}/image/2.jpg");
            background-repeat: repeat
        }
    </style>
</head>
<body>&nbsp;
<center>
    <img src="${pageContext.request.contextPath}/image/success.gif"/>
    <h1> 已成功将${requestScope.production.productname}商品添加至购物车</h1>
    <h1><a href="${pageContext.request.contextPath}/product/showAll">继续购物</a>&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/cart.jsp">去购物车结算</a>
    </h1>
</center>
</body>
</html>