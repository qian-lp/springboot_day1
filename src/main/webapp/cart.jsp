<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script src="${pageContext.request.contextPath}/js/shopcar.js"></script>
    <style type="text/css">
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

    </style>
</head>
<body>&nbsp;

<!-- Title -->
<img src="${pageContext.request.contextPath}/image/zgc_px.jpg" align="middle" class="f"/>
<span>欢迎访问我的购物网站</span>
<hr/>

<!--  Menu Bar  -->
<center>
    <div class="d">
        <a href="QueryProductView.html"><img src="${pageContext.request.contextPath}/image/index.gif"/></a>
        <a href="UserManageView.html"><img src="${pageContext.request.contextPath}/image/reg.gif"/></a>
        <a href="ShopCarView.html"><img src="${pageContext.request.contextPath}/image/cart.gif"/></a>
        <a href=""><img src="${pageContext.request.contextPath}/image/order.gif"/></a>
        <a href="LoginView.html"><img src="${pageContext.request.contextPath}/image/exit.gif"/></a>
    </div>
</center>


<form action="" method="post">
    <table border="1" bordercolor="blue" cellspacing="0" align="center" width="80%">
        <tbody id="tbody">
        <tr bgcolor="lightblue" align="center">
            <td><b>&nbsp;</b></td>
            <td><b>商品编号</b></td>
            <td><b>商品名称</b></td>
            <td><b>图片</b></td>
            <td><b>商品单价</b></td>
            <td><b>数量</b></td>
            <td><b>总价</b></td>
            <td><b>删除</b></td>
        </tr>
        <c:forEach items="${sessionScope.cart.map}" var="m">
            <c:set var="item" value="${m.value}"></c:set>
            <tr onmouseover="over(this);" onmouseout="out(this);" align="center">
                <td><input type="checkbox"/></td>
                <td>${item.production.id}</td>
                <td>${item.production.productname}</td>
                <td><img src="${item.production.path}"/></td>
                <td>${item.production.price}</td>
                <td>
                    <input type="button" value="-" onclick="sub(this);"/><input type="text" value="1" size="1"
                                                                                maxlength="1" name="1"/><input
                        type="button" value="+" onclick="add(this);"/>
                </td>
                <td>${item.subTotal}</td>
                <td><a href="${pageContext.request.contextPath}/shopping/delete?id=${item.production.id}">删除</a></td>
            </tr>
        </c:forEach>

        <tr align="center">
            <td colspan="7">
                <input type="button" value="选中所有行" onclick="selectAll();"/>
                <input type="button" value="取消选中" onclick="quxiao();"/>
                <input type="button" value="删除选中的行" onclick="deleteSelected();"/>
            </td>
        </tr>
        </tbody>
    </table>
    <center><p><input type="submit" value="提交修改"/></p></center>
</form>
<center>
    <hr/>
    <a href="">提交订单</a>
</center>
</body>
</html>