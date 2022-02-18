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
<script type="text/javascript"></script>
<title>アカウント修正画面</title>
<script type="text/javascript">
	function confim() {
		//ダイアログの処理
		if (window.confirm('本当によろしいですか？')) { // 確認ダイアログを表示
			return true; // 「OK」時は送信を実行
		} else { // 「キャンセル」時の処理
			window.alert('キャンセルされました'); // 警告ダイアログを表示
			return false; // 送信を中止
		}
	}
</script>
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
			<a href="Administrator" class="btn btn--white btn-outline-dark">アカウント修正画面</a>
			<!-- 管理者画面へ遷移させる -->
			<h2 class="text-center border-bottom border-dark">アカウント修正画面</h2>
		</div>
		
		<form method="post" onsubmit="return confim()">
			<div>
				<table class="table table-bordered ">
					<tbody>
						<tr>
							<%
							for (String[] s : list) {
							%>
							<th class="midashi">アカウント名</th>
							<td><input type="text" size="50" name="name"
								value=<%=s[0]%>>
							<!--アカウント名を入力するテキストボックス--></td>
						</tr>
						<tr>
							<th class="midashi">メールアドレス</th>
							<td><input type="text" size="50" email="email" name="email"
								value=<%=s[1]%>>
							<!--メールアドレスを入力するテキストボックス--></td>

						</tr>
						<tr>
							<th class="midashi">管理者
							<td><input type="checkbox" class="big2" name="flg" value=1>
							</td>

						</tr>
						<input type="hidden" name="id" value=<%=s[3]%>>

						<%
						}
						%>
					</tbody>
				</table>
			</div>
			<h3 style="text-align: center;">
				<button type="submit" formaction="AccountFix4"
					class="btn btn--blue btn-outline-primary">
					修正する
					<!-- アカウント追加画面へ遷移させる-->
				</button>
				<button type="submit" formaction="AccountFix3"
					class="btn btn--red btn-outline-danger" id="Fix">削除する</button>
				<!-- アカウントを削除する-->
			</h3>
		</form>
	</div>
</body>
</html>