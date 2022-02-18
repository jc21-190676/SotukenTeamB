<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="staff.bean.RequestBean, java.util.List"%>
<%
	List<RequestBean> list = (List<RequestBean>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link href="/R03TeamB/css_js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/R03TeamB/css_js/M01/RequestManagement.css" rel="stylesheet" type="text/css">
    <title>依頼管理画面</title>
</head>

<body class="container mt-3">
    <h1 class="button-name right mb-0">
        <button type="submit" class="out btn-outline-primary" onclick="location.href='../openidSignOut'">ログアウト</button>
    </h1>
    <div class="m-2 mt-0">
        <h1 class="button-name1">
            <button type="submit" class="top btn-outline-danger" onclick="location.href='../Administrator'">管理者画面</button>
        </h1>            
        <h1 class="button-name2">
            <button type="submit" class="check btn-outline-primary" onclick="location.href='../m03_InventoryList/InventoryListServlet'">在庫一覧</button> <!-- 四角角丸-->
        </h1>        
    </div>

    <div class="title">
        <h2 class="text-center">依頼管理画面</h2>
    </div>

    <div>
        <% if(list!=null){%>
        	<table class="table table-bordered">
        
        		<tr class="center">
            		<th>受付ID</th>
            		<th>学籍番号</th>
            		<th>受付日</th>
            		<th>依頼の管理状態</th>
            		<th>依頼の管理状態を変更する</th>
            	</tr>
           	 	<tbody>
	        		<%for(RequestBean rb : list){ %>
                	<tr>
                    	<td class="center"><a href = "../m02_requestdetails/RequestDetailsServlet?id=<%=rb.getReception_id()%>" id="IDlink"><%= rb.getReception_id() %></a></td>
                    	<td class="center"><%=rb.getStudent_no() %></td>
                    	<td class="center"><%=rb.getReception_date() %></td>
                    	<td class="center"><%=rb.getDivision_flag() %></td>
                    	<td class="center"><button class="btn btn-secondary" type="submit" onclick="location.href='../m01_requestmanagement/FlagChangeServlet?Recid=<%=rb.getReception_id() %>'"><%=rb.getNext_flag()%></button></td>
                	</tr>
           		 	<%}%>
            	</tbody>
        </table>
        <%}else{%>
        	<h1>データがありません</h1>
        <%}%>
    </div>
</body>