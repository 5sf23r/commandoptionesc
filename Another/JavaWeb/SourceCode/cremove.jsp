<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>

  <body>
        <h1>c:remove标签 删除作用域中的值</h1>
        <h3>1. 删除指定作用域中的值</h3>
        <c:set var="city" value="北京" scope="page"></c:set>
        <c:set var="city" value="太原" scope="request"></c:set>
        <c:set var="city" value="石家庄" scope="session"></c:set>
        <c:set var="city" value="青岛" scope="application"></c:set>
        city=${city}<br>
        <c:remove var="city" scope="page" />
        city=${city}<br>
        <c:remove var="city" scope="request" />
        city=${city}<br>
        <c:remove var="city" scope="session" />
        city=${city}<br>
        <c:remove var="city" scope="application" />
        city=${city}<br>
        <hr>
        <h3>2. 如果不指定scope，则删除4大作用域中所有该name的值</h3>
    <c:set var="city" value="北京" scope="page"></c:set>
        <c:set var="city" value="太原" scope="request"></c:set>
        <c:set var="city" value="石家庄" scope="session"></c:set>
        <c:set var="city" value="青岛" scope="application"></c:set>
        city=${city}<br>
        <c:remove var="city"/>
        city=${city}


        <hr>
        <br><br><br><br><br>
  </body>
</html>