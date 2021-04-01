<%--
  Created by IntelliJ IDEA.
  User: sang
  Date: 2021/3/29
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <div>04</div>
    <div>
        <form action="/upload4" method="post" enctype="multipart/form-data">
            <input type="file" name="file">
            <input type="text" value="www.javaboy.org" name="other_param">
            <input type="submit" value="提交">
        </form>
    </div>
</div>
<div>
    <div>03</div>
    <div>
        <form action="/upload3" method="post" enctype="multipart/form-data">
            <input type="file" name="file">
            <input type="text" value="www.javaboy.org" name="other_param">
            <input type="submit" value="提交">
        </form>
    </div>
</div>
<div>
    <div>02</div>
    <div>
        <form action="/upload2" method="post" enctype="multipart/form-data">
            <input type="file" name="file">
            <input type="text" value="www.javaboy.org" name="other_param">
            <input type="submit" value="提交">
        </form>
    </div>
</div>
<div>
    <div>01</div>
    <div>
        <form action="/upload" method="post" enctype="multipart/form-data">
            <input type="file" name="file">
            <input type="text" value="www.javaboy.org" name="other_param">
            <input type="submit" value="提交">
        </form>
    </div>
</div>
</body>
</html>
