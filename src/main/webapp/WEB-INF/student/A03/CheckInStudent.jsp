<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.util.ArrayList,student.bean.StudentBean,student.bean.Certificate" %>
<%StudentBean sb = (StudentBean)session.getAttribute("sb");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link href="/R03TeamB/css_js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/R03TeamB/css_js/A03/check-in-style.css" rel="stylesheet" type="text/css">
<title>入力内容確認画面</title>
</head>

<body>
	<div class="container mt-5 pt-5">
		<div class="title">
			<h1 class="text-center border-bottom border-dark">入力内容確認画面</h1>
		</div>
		<form action="Check" method="post">
			<table class="table table-bordered ">
				<tbody>
					<tr>
						<th>名前</th>
						<td><span><%=sb.getName() %></span></td>

					</tr>
					<tr>
						<th>生年月日</th>
						<td><span><%=sb.getBirthday() %></span></td>
					</tr>
					<tr>
						<th>学年・学科</th>
						<td>
							<div class="row mb-0 col">
								<%String dept = null;
								switch(sb.getDept()){
									case "A01":
										dept = "建築科";
										break;
									case "A02":
										dept = "建築大工技能科";
										break;
									case "A03":
										dept = "インテリア科";
										break;
									case "A04":
										dept = "電気工事科";
										break;
									case "A05":
										dept = "機械CAD設計科";
										break;
									case "B01":
										dept = "国際ビジネス科";
										break;
									case "C01":
										dept = "ゲームクリエーター科";
										break;
									case "C02":
										dept = "ゲームエンジニア科";
										break;
									case "C03":
										dept = "CGクリエーター科";
										break;
									case "C04":
										dept = "Webクリエーター科";
										break;
									case "C05":
										dept = "デジタルデザイン科";
										break;
									case "C06":
										dept = "デジタルミュージック科";
										break;
									case "C07":
										dept = "映像放送科";
										break;
									case "C08":
										dept = "音響制作科";
										break;
									case "D01":
										dept = "モバイルアプリケーション科";
										break;
									case "D02":
										dept = "情報システム科";
										break;
									case "D03":
										dept = "AIシステムエンジニア科";
										break;
									case "D04":
										dept = "ネットワークシステム科";
										break;
									case "D05":
										dept = "サイバーセキュリティ科";
										break;
									case "D06":
										dept = "AIテクノロジーエンジニア科";
										break;
									case "D07":
										dept = "高度ITエンジニア科";
										break;
									case "D08":
										dept = "システムエンジニア科";
										break;
									case "E01":
										dept = "総合情報ビジネス科";
										break;
									default:
										dept = "エラー";
										break;
								}
								%>
								<span><%=sb.getGrade()+"年 "+dept %></span>
							</div>
						</td>
					</tr>
					<tr>
						<th>メールアドレス</th>
						<td><%=sb.getMail() %></td>
					</tr>
					<tr>
						<th>寮名</th>
						<td>
							<div>
							<%String dor=null;
								 switch(sb.getDormitory()){
								 	case "R1":	
								 		dor = "寮に住んでない";
								 		break;
								 	case "R2":
								 		dor = "清水寮";
								 		break;
								 	case "R3":
								 		dor = "ドミトリー仙台一番町";
								 		break;
								 	case "R4":
								 		dor = "北山寮";
								 		break;
								 	default :
								 		dor = "エラー";
								 		break;
								 }
								%>
								<span><%=dor%></span>
							</div>
						</td>
					</tr>
				</tbody>
			</table>

			<!-- テーブル2↓-->
			<table class="table table-bordered ">
				<tr class="center">
					<th>申込書類</th>
					<th>手数料</th>
					<th>必要数</th>
					<th>小計</th>
				</tr>
				<tr>
					<td>成績証明書</td>
					<td class="right">200円</td>
					<td class="right"><span><%=sb.getCertList().get(0).getQuantity() %></span></td>
					<td class="right"><%=sb.getCertList().get(0).getPrice()%></td>
				</tr>
				<tr class="right">
					<td class="left">卒業見込証明書</td>
					<td>200円</td>
					<td class="right"><span><%=sb.getCertList().get(1).getQuantity() %></span></td>
					<td class="right"><%=sb.getCertList().get(1).getPrice()%></td>
				</tr>
				<tr class="right">
					<td class="left">卒業証明書</td>
					<td>200円</td>
					<td class="right"><span><%=sb.getCertList().get(2).getQuantity() %></span></td>
					<td class="right"><%=sb.getCertList().get(2).getPrice()%></td>
				</tr>
				<tr class="right">
					<td class="left">在学証明書</td>
					<td>200円</td>
					<td class="right"><span><%=sb.getCertList().get(3).getQuantity() %></span></td>
					<td class="right"><%=sb.getCertList().get(3).getPrice()%></td>
				</tr>
				<tr class="right">
					<td class="left">在寮証明書</td>
					<td>200円</td>
					<td class="right"><span><%=sb.getCertList().get(4).getQuantity() %></span></td>
					<td class="right"><%=sb.getCertList().get(4).getPrice()%></td>
				</tr>
				<tr class="right">
					<td class="left">学生証</td>
					<td>300円</td>
					<td class="right"><span><%=sb.getCertList().get(5).getQuantity() %></span></td>
					<td class="right"><%=sb.getCertList().get(5).getPrice()%></td>
				</tr>
				<tr>
					<td colspan="3">合計金額</td>
					<td class="right"><%=sb.getSum() %></td>
				</tr>
			</table>

			<!-- ボタン部分 -->
			<div class="row p-5">
				<div
					class="card text-center col-md d-lg-flex align-items-center border-0">
					<h3 class="button-name">
						<button type="submit" name="btnState" value="top"  class="baka btn-outline-danger">トップページへ</button>
					</h3>
				</div>

				<div
					class="card text-center col-md d-lg-flex align-items-center border-0">
					<h2 class="button-name">
						<button type="submit" name="btnState" value="send" class="aho btn-outline-primary">送信</button>
					</h2>
				</div>
			</div>
			
		</form>
	</div>

</body>
</html>