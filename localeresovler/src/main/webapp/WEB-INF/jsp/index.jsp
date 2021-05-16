<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<spring:theme code="index.body" />" >
</head>
<body>
<div>
    一键切换主题：<br/>
    <a href="/index?theme=blue">托帕蓝</a>
    <a href="/index?theme=red">多巴胺红</a>
    <a href="/index?theme=green">石竹青</a>
</div>
<br/>
</body>
</html>