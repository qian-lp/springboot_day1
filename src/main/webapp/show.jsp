<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style type="text/css">
        .c1 {
            text-align: right;
            margin-right: 50px
        }

        .c2 {
            text-align: right;
            margin-right: 50px;
            color: blue;
            font-size: 150%
        }

        body {
            background-image: url("${pageContext.request.contextPath}/image/2.jpg");
            background-repeat: repeat
        }

        span {
            font-size: 30px;
            color: red;
            font-weight: bolder;
            margin-left: 200px
        }

        .f {
            width: 150px;
            height: 70px
        }

        .d {
            text-align: center;
            word-spacing: 20px;
            width: 70%
        }

        img {
            border: none
        }

        .b {
            background-color: yellow;
            background-image: url("${pageContext.request.contextPath}/image/button12.gif");
            width: 60px;
            height: 30px;
            border: none
        }

    </style>
</head>
<body>&nbsp;

<!-- Title -->
<img src="${pageContext.request.contextPath}/image/zgc_px.jpg" align="middle" class="f"/>
<span>欢迎访问我的购物网站</span>
<hr/>

<div class="c2"> 欢迎Luxw</div>

<!--  Menu Bar  -->
<center>
    <div class="d">
        <a href="QueryProductView.html"><img src="${pageContext.request.contextPath}/image/index.gif"/></a>
        <a href="UserManageView.html"><img src="${pageContext.request.contextPath}/image/reg.gif"/></a>
        <a href="ShopCarView.html"><img src="${pageContext.request.contextPath}/image/Car.gif"/></a>
        <a href=""><img src="${pageContext.request.contextPath}/image/order.gif"/></a>
        <a href="LoginView.html"><img src="${pageContext.request.contextPath}/image/exit.gif"/></a>
    </div>
</center>

<!--  按条件搜索表单 -->
<center>
    <form action="" method="post">
        ProductName:<input type="text" name="productName"/>&nbsp;
        Price:<select name="opt">
        <option value="1">小于</option>
        <option value="2">大于</option>
    </select>
        <input type="text" name="price" size="6"/> &nbsp;&nbsp;
        <input type="submit" value="" class="b"/>
    </form>
</center>

<table border="1" bordercolor="blue" cellspacing=0 align="center" width="70%">
    <tr align="center" bgcolor="lightblue">
        <td><b>Id</b></td>
        <td><b>Name</b></td>
        <td><b>图片</b></td>
        <td><b>Price</b></td>
        <td><b><img src="${pageContext.request.contextPath}/image/car_new.gif"/></b></td>
    </tr>
    <c:forEach items="${requestScope.productions}" var="production">
        <tr align="center">
            <td>${production.id}</td>
            <td>${production.productname}</td>
            <td><img src="${production.path}"/></td>
            <td>${production.price}</td>
            <td align="center"><a href="${pageContext.request.contextPath}/shopping/add?id=${production.id}"><img
                    src="${pageContext.request.contextPath}/image/car_new.gif"/></a></td>
        </tr>
    </c:forEach>

</table>
<p>&nbsp;</p>

<!-- 分页 -->
<center>
    <a href="">上一页</a>
    &nbsp;
    这是第 <font color="red">1</font> 页/共${sessionScope.totalPage}页
    &nbsp;

    <a href="${pageContext.request.contextPath}/product/showAll?page=">下一页</a>
    &nbsp;

</center>

</body>
</html>