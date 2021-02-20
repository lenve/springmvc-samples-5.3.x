<%--
  Created by IntelliJ IDEA.
  User: sang
  Date: 2021/2/8
  Time: 09:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>添加图书</h1>
<form action="/book/addbook2" method="post">
    <table>
        <tr>
            <td>图书名称</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>图书作者</td>
            <td><input type="text" name="author.name"></td>
        </tr>
        <tr>
            <td>作者年龄</td>
            <td><input type="text" name="author.age"></td>
        </tr>
        <tr>
            <td>作者兴趣爱好</td>
            <td>
                <input type="checkbox" value="乒乓球" name="author.favorites">乒乓球
                <input type="checkbox" value="篮球" name="author.favorites">篮球
                <input type="checkbox" value="蹴鞠" name="author.favorites">蹴鞠
            </td>
        </tr>
        <tr>
            <td>
                作者角色
            </td>
            <td>
                <input type="checkbox" value="管理员" name="author.roles[0].name">管理员
                <input type="hidden" value="1" name="author.roles[0].id">
                <input type="checkbox" value="用户" name="author.roles[1].name">用户
                <input type="hidden" value="2" name="author.roles[1].id">
            </td>
        </tr>
        <tr>
            <td>出版时间</td>
            <td><input type="date" name="publishDate"></td>
        </tr>
        <tr>
            <td>出版社</td>
            <td><input type="text" name="info['publish']"></td>
        </tr>
        <tr>
            <td>责任编辑</td>
            <td><input type="text" name="info['editor']"></td>
        </tr>
        <tr>
            <td>图书价格</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td><input type="submit" value="添加"></td>
        </tr>
    </table>
</form>
</body>
</html>
