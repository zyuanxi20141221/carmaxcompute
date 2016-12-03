<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.goopai.carmaxcompute.domain.Car" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list car</title>
<style type="text/css">
   body{
   
       }
   #btn{
       margin-top:15px;
   }
   
   table{
           text-align:left;
           width:992px;
           border:1;
           cellspacing:0;
           table-layout: fixed;
        }
    .index{width:2px;}
    .title{width:30px;}
    .pubtime{width:20px;}
    td {white-space:nowrap;overflow:hidden;align:center;}
    
    #bottom{
              margin-top:20px;
           }
</style>

<script type="text/javascript">

    function getTdValue(){
    	var tableid = document.getElementById("carinfo_tb");
    	for(var i=1;i<tableid.rows.length;i++){
    		var value = tableid.rows[i].cells[7].innerHTML;
    		
    	}
    }
</script>

</head>
<body>
     <table id="carinfo_tb">
            <tr>
                <th class="index">序号</th>
                <th class="title">标题</th>
                <th class="pubtime">发布时间</th>
            </tr>
        <c:forEach var = "car" items = "${list}" varStatus="varStatus">
          <tr bgcolor="${varStatus.index%2==1?'efefef':'ffffff'}">
             <td><c:out value="${varStatus.index + 1}"></c:out></td>
             <td><a href="${pageContext.request.contextPath}/CarInfoServlet?action=detail&id=${car.id}"><c:out value="${car.title}"></c:out></a></td>
             <td><c:out value="${car.publishtime}"></c:out></td>
          </tr>
        </c:forEach>
        </table>
 <div id="bottom">
     <a href='./CarInfoServlet?page=first'>首页</a>|<a href='./CarInfoServlet?page=next'>下一页</a>|<a href='./CarInfoServlet?page=pre'>上一页</a>|<a href='./CarInfoServlet?page=last'>尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;总记录数:${page.totalCount}&nbsp;&nbsp;总页数:${page.totalPage }&nbsp;&nbsp;当前页:${page.page}<br/>
 </div>
  <div id="btn">
         <input type="button" name="getcontent" value="获取内容" onClick="getTdValue()"/>
     </div>
</body>
</html>