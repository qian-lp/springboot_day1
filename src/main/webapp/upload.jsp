<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/file/upload" method="post" enctype="multipart/form-data">

    <input type="file" name="bb"/>
    <input type="submit" value="上传"/>
</form>
<hr>
<a href="${pageContext.request.contextPath}/file/download?fileName=9.png">下载9.png</a>
</body>
</html>