<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的直播</title>
 <%@include file="../../common/BasePath.jsp" %>

<script type="text/javascript" src="js/chat/manage/owner.js"></script>
</head>
<body>
${msg}
<button id="start">开始直播</button>
<div></div>
${socketURI}
</body>
</html>