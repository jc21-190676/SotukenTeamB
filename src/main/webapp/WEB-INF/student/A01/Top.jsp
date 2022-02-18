<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<link href="/R03TeamB/css_js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="/R03TeamB/css_js/A01/top-style.css" rel="stylesheet" type="text/css">
	<title>トップページ</title>
</head>

<body>
	<div class="container mt-5 pt-5">
		<div class="title">
			<h1 class="text-center border-bottom border-dark">証明書申込システム</h1>
		</div>
		<form action="Entry" method="get">
			<div class="row p-5">
				<div class="card col-md d-lg-flex align-items-center border-0">
					<h3 class="button-name">
						<button type="submit" value="ja" name="btnState" class="rounded-circle shadow p-5 btn btn-outline-danger"
							style="width: 15rem; height: 15rem">日本人学生</button>
					</h3>
					<p>日本人学生はこちら</p>
				</div>

				<div class="card col-md d-lg-flex align-items-center border-0">
					<h2 class="button-name">
						<button type="submit" value="in" name="btnState" class="rounded-3 shadow p-5 btn btn-outline-dark"
							style="width: 15rem; height: 15rem">留学生</button>
					</h2>
					<p>留学生はこちら</p>
				</div>
			</div>
		</form>
	</div>

</body>



</html>