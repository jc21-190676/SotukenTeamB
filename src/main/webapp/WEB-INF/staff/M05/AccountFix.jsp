<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Optional"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/R03TeamB/css_js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/R03TeamB/css_js/M05/AccountFix.css" rel="stylesheet" type="text/css">
    
<title>アカウント修正画面</title>
</head>
<%
Optional<List<String[]>> optList = Optional.ofNullable((List<String[]>) request.getAttribute("list"));
List<String[]> list = new ArrayList<>();
if (optList.isPresent()) {
	list = optList.get();
}
%>
	
<body>
<div class="container mt-5 pt-5">
    <div class="title">
		
        <a href="Administrator" class="btn btn--white btn-outline-dark">管理者画面</a><!-- 依頼管理画面へ遷移させる -->
		
			
        <h2 class="text-center border-bottom border-outline-dark">アカウント修正画面</h2>
            
        </div>
        <div>   
            <table class="table table-bordered ">
                    <tr>
                    	<th>
                            アカウントID
                        </th>
                        <th>
                            アカウント名
                        </th>
                        <th>
                            メールアドレス
                        </th>
                        <th class="center">
                            管理者
                        </th>
                        
                      </tr>                    
                    <%	for (String[] s : list) { %> 
						
					<tr>					
						<td>
						<form action="AccountFix2" method="post">
                            <button type="submit" class="btn btn--link" name="id" value=<%=s[3] %>><%=s[3] %><!-- ここにアカウントIDを送信する --></button>
                        </form>
                        </td>                    
	          			<td>
                            <span><%=s[0] %><!-- ここにアカウント名を取得して表示させる --></span>
                        </td>
                        <td>
                            <span><%=s[1] %><!-- ここにメールドレスを取得して表示させる --></span>
                        </td>
                
                        <% if (s[2].equals( "1") ){ %>
                          	<td class="cbox">                            	
                            	yes
                        	</td> 
                        <% } else { %>
                        	<td class="cbox">             
                            	no                     	
                        	</td>
                        <% } %>
                     </tr>                 
	                <%
					}
					%> 
            	</table>
        	</div> 
		</div>
	</body>
</html>