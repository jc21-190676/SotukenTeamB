<%@page import="staff.bean.RequestDetailsBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="staff.bean.RequestDetailsBean, java.util.List"%>
<%
List<RequestDetailsBean> list = (List<RequestDetailsBean>) request.getAttribute("RDlist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/R03TeamB/css_js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/R03TeamB/css_js/M02/RequestDetails.css" rel="stylesheet" type="text/css">
<title>依頼内容詳細画面</title>
</head>

<body class="container mt-3">
	<div class="m-2 mt-0">
		<h1 class="button-name1">
			<button type="submit" class="top btn-outline-danger" class="left"
				onclick="location.href='../m01_requestmanagement/RequestManagementServlet'">依頼管理画面
			</button>
		</h1>
	</div>

	<div class=" m-2 mt-0">
		<h1 class="button-name2">
			<button type="submit" class="check btn-outline-primary"
				onclick="location.href='../m03_InventoryList/InventoryListServlet'">在庫一覧
			</button>
		</h1>
	</div>
	
	<%if(list!= null || list.size() != 0) {%>
		<table class="table table-bordered mt-5">
		<tbody>
			<tr>
				<td class="center" colspan="3"><%=list.get(0).getName()%></td>
			</tr>

			<tr>
				<th class="center">受付ID</th>
				<th class="center">学籍番号</th>
				<th class="center">生年月日</th>
			</tr>

			<tr>
				<td class="center"><%=list.get(0).getReception_id()%></td>
				<td class="center"><%=list.get(0).getStudent_no()%></td>
				<td class="center"><%=list.get(0).getBirthday()%></td>

			</tr>
			<tr>
				<th class="center">受付日</th>
				<th class="center">学年</th>
				<th class="center">学科</th>
			</tr>
			<tr>
				<td class="center"><%=list.get(0).getReception_date()%></td>
				<td class="center"><%=list.get(0).getSchool_grade()%></td>
				<td class="center"><%=list.get(0).getDept_name()%></td>
			</tr>
			<tr>
				<th class="center" colspan="2">証明書の種類</th>
				<th class="center">部数</th>
			</tr>
			<%	
			 for (RequestDetailsBean rdb : list) {
			%>
			<tr>
				<td class="center" colspan="2"><%=rdb.getCertificate_name()%></td>
				<td class="center"><%=rdb.getQuantity()%></td>
			</tr>
			<%}%>
		</tbody>
	</table>

	<div class="price">
		<table class="table table-bordered " style="width: 50%">
			<tbody>
			<thead>
				<tr>
					<th style="width: 40%">合計金額</th>
					<td style="width: 60%" class="right"><%=list.get(0).getTotal_price()%></td>
				</tr>
			</thead>
			</tbody>
		</table>
	</div>
	<%}else{%>
		<h1>データがありません</h1>
	<%}%>
</body>