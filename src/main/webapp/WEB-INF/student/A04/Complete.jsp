<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% int reception_id = (Integer)request.getAttribute("reception_id"); %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link href="/R03TeamB/css_js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="/R03TeamB/css_js/A04/complete-style.css" rel="stylesheet" type="text/css">
    <title>申込完了画面</title>
</head>

<body>
    <div class="container mt-5 pt-5">
        <div class="title">
            <h1 class="text-center border-bottom border-dark">申込完了画面</h1>
        </div>
        
        <p class="center">証明書の依頼が完了しました</p>
        <p>証明書の準備が完了次第メールします </p>
        <table class="table table-bordered">
            <tbody>
                <tr>
                    <td style="width:30%"><h3>受付ID</h3></td>
                    <td><h3><%=reception_id%></h3></td>
                </tr>
            </tbody>
        </table>  
           
        <form action="Complete" method="post">
            <div class="card col-md d-lg-flex align-items-center border-0">
                    <h3 class="button-name">
                        <button type="submit" name="btnState" value="top" class="baka btn-outline-danger">トップページへ</button>
                    </h3>
            </div>
        </form>  
    </div> 
</body>   