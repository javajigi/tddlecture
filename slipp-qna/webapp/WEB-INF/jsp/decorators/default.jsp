<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"
%><%@ include file="/WEB-INF/jsp/include/tags.jspf" 
%><!DOCTYPE html>
<html lang="ko">
  <head>
    <title><decorator:title default="SLiPP" /></title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" media="screen"  href="/resources/stylesheets/main.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>    
    <decorator:head />
  </head>
  <body>
        <div id="header">
            <div id="logo">
                <a href="/">SLiPP</a>
            </div>
            <ul id="tools">
                <li>
                    <a href="/user/login/form">Log in</a>
                </li>
            </ul>
            <div id="title">
                <h2>지속 가능한 삶, 프로그래밍, 프로그래머</h2>
            </div>
        </div>
        
        <decorator:body/>
        
        <%@ include file="/WEB-INF/jsp/include/footer.jspf" %> 
  </body>
</html>