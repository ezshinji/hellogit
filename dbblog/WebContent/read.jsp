<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="blog.Topic" %>
<%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<h2>シンプルBlog</h2>
<a href="ReadServlet">リロード</a>
<form action="PostServlet" method="post">
	<p>タイトル<input type="text" name="title" size="40" /></p>
	<textarea name="content" rows="5" cols="40"></textarea>
	<input type="submit" name="submit" value="投稿" />
</form>
<%
	List<Topic> topics = (List)request.getAttribute("topics");
	if(topics != null){
		StringBuilder sb = new StringBuilder();
		for(int i=topics.size()-1; i >= 0; i--){
			Topic topic = topics.get(i);
			sb.append("<hr></hr>");
			sb.append("タイトル　" + topic.getTitle());
			sb.append("  " + topic.getPostDate());
			sb.append("<pre>");
			sb.append(topic.getContent());
			sb.append("</pre>");
		}
		out.println(sb);
	}
%>
</body>
</html>