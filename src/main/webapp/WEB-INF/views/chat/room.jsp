<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<%@include file="../common/BasePath.jsp" %>
<script type="text/javascript" >var socketURI = '${socketURI }';</script>
<script type="text/javascript"  src="js/chat/room.js"></script>
<body>
Hello world
${socketURI }
<input type="text" id="msg">
<button id="btn">发送</button>
<ul id="list"></ul>
</body>
</html>