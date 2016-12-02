<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${object.title}</title>
<style>
    body{
    	   text-align:center;
        }
        
    #container{
           width:980px;
           text-align:center;
    }
    
</style>
</head>
<body>
<div id="container">
<h2 align="center">${object.title}</h2>
<p>发布时间:${object.publishtime}&nbsp;&nbsp;&nbsp;作者:${object.author}&nbsp;&nbsp;&nbsp;来源:${object.source}&nbsp;&nbsp;&nbsp;分类:${object.category}</p>
${object.content}
</div>
</body>
</html>