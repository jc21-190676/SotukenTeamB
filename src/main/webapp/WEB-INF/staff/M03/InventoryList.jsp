<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="staff.bean.InventoryListBean, java.util.List"%>
<%
	List<InventoryListBean> list = (List<InventoryListBean>)request.getAttribute("Ilist");
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link href="/R03TeamB/css_js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/R03TeamB/css_js/M03/InventoryList.css" rel="stylesheet" type="text/css">
    <title>在庫一覧画面</title>
</head>

<body class="container mt-3">
    <h1 class="button-name right mb-0">
        <button type="submit" class="out btn-outline-primary" onclick="location.href='../com.gmail.yoshzawa.openid/Jc21MSOpenSigninServlet'">ログアウト</button>
    </h1>
    <div class="m-2 mt-0">
        <h1 class="button-name1">
            <button type="submit" class="top btn-outline-danger"  onclick="location.href='../m01_requestmanagement/RequestManagementServlet'">依頼管理画面</button>
        </h1>
    </div>

    <div class="title">
        <h2 class="text-center">在庫一覧</h2>
    </div>

    <div>
        <table class="table table-bordered">
            <tbody>
            	<tr class="center">
            		<th>受付ID</th>
            		<th>メールアドレス</th>
            		<th>受付日</th>
            	</tr>
        		<% for(InventoryListBean ib : list){ %>
                	<tr>
                  	 <td class="center"><a href = "../m02_requestdetails/RequestDetailsServlet?id=<%=ib.getReception_id()%>" id="IDlink"><%= ib.getReception_id() %></a></td>
                   	 <td class="center"><%=ib.getEmail() %></td>
                   	 <td class="center"><%=ib.getReception_date() %> </td>
               	 </tr>
                <%} %>
            </tbody>
        </table>
    </div>
</body>