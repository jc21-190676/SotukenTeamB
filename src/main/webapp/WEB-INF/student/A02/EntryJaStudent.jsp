<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link href="/R03TeamB/css_js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/R03TeamB/css_js/A02/entry-ja-style.css" rel="stylesheet" type="text/css">
<link href="/R03TeamB/css_js/flatpickr/flatpickr.min.css" rel="stylesheet">
<link href="/R03TeamB/css_js/flatpickr/dark.css" rel="stylesheet">
<script type="text/javascript" src="/R03TeamB/css_js/flatpickr/flatpickr.js"></script>
<title>証明書申込画面</title>
</head>

<body>
	<div class="container mt-5 pt-5">
		<div class="title pb-3">
			<h1 class="text-center border-bottom border-dark">日本人学生用　証明書申込画面</h1>
		</div>
		<form action="EntrySave" method="post">
			<table class="table table-bordered">
				<tbody>
					<tr>
						<th>名前</th>
						<td><input type="text" name="name" class="form-control" required="required"></td>
					</tr>
					
					<tr>
						<th>学籍番号</th>
						<td><input type="number" name="no" class="form-control no-spin" min="0" max="9999999" required="required"></td>
					</tr>
					
					<tr>
						<th>生年月日</th>
						<td class="flatpickr input-group" data-wrap="true" data-clickOpens="true">
							<input type="text" name='birthday' class="form-control"  placeholder="生年月日を選択" data-input required="required">
							<script>
								flatpickr('.flatpickr', {
									dataFormat: 'd-m-Y'	//データをformat
								});
							</script>
						</td>
					</tr>
					<tr>
						<th>学年・学科</th>
						<td>
							<div class="row">
								<div class="mb-3 col">
									<select class="form-select" name="grade" id="exampleFormSelect1">
										<option value="4" selected>４年</option>
										<option value="3">３年</option>
										<option value="2">２年</option>
										<option value="1">１年</option>
									</select>
								</div>

								<div class="mb-3 col">
									<select class="form-select" name="dept" id="exampleFormSelect1">
										<option value="D08" selected>システムエンジニア</option>
										<option value="A01">建築科</option>
										<option value="A02">建築大工技能科</option>
										<option value="A03">インテリア科</option>
										<option value="A04">電気工事科</option>
										<option value="A05">機械CAD設計科</option>
										<option value="B01">国際ビジネス科</option>
										<option value="C01">ゲームクリエーター科</option>
										<option value="C02">ゲームエンジニア科</option>
										<option value="C03">CGクリエーター</option>
										<option value="C04">Webクリエーター</option>
										<option value="C05">デジタルデザイン科</option>
										<option value="C06">デジタルミュージック科</option>
										<option value="C07">映像放送科</option>
										<option value="C08">音響制作科</option>
										<option value="D01">モバイルアプリケーション科</option>
										<option value="D02">情報システム科</option>
										<option value="D03">AIシステムエンジニア科</option>
										<option value="D04">ネットワークシステム科</option>
										<option value="D05">サイバーセキュリティ科</option>
										<option value="D06">AIテクノロジーエンジニア科</option>
										<option value="D07">高度ITエンジニア科</option>
										<option value="E01">総合情報ビジネス科</option>
									</select>
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<th>メールアドレス</th>
						<td><input type="email" name="mail" class="form-control" placeholder="例：123456@jc-21.jp" required="required"></td>
					</tr>
					<tr>
						<th>寮名</th>
						<td>
							<div class="mb-3">
								<select class="form-select" name="dormitory" id="exampleFormSelect1">
									<option value="R1" selected>寮に住んでいない</option>
									<option value="R2">清水寮</option>
									<option value="R3">ドミトリー仙台一番町</option>
									<option value="R4">北山寮</option>
								</select>
							</div>
						</td>
					</tr>
				</tbody>
			</table>

			<table class="table table-bordered" id="table_calc">
				<tr class="center">
					<th>申込書類</th>
					<th>手数料</th>
					<th>必要数</th>
					<th>小計</th>
				</tr>

				<tr class="right">
					<td class="left"><input type="hidden" name="certList" value="B1">成績証明書</td>
					<td><input type="hidden" name="priceList" value="200">200円</td>
					<td><select class="form-select" name="quantityList" id="exampleFormSelect1" onchange="calcSubTotal(0)">
							<option value="0" selected>0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="8">9</option>
					</select></td>
					<td class="subtotal">0</td>
				</tr>

				<tr class="right">
					<td class="left"><input type="hidden" name="certList" value="B2">卒業見込証明書</td>
					<td><input type="hidden" name="priceList" value="200">200円</td>
					<td><select class="form-select" name="quantityList" id="exampleFormSelect1" onchange="calcSubTotal(1)">
							<option value="0" selected>0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="8">9</option>
					</select></td>
					<td class="subtotal">0</td>
				</tr>

				<tr class="right">
					<td class="left"><input type="hidden" name="certList" value="B3">卒業証明書</td>
					<td><input type="hidden" name="priceList" value="200">200円</td>
					<td><select class="form-select" name="quantityList" id="exampleFormSelect1" onchange="calcSubTotal(2)">
							<option value="0" selected>0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="8">9</option>
						</select>
					</td>
					<td class="subtotal">0</td>
				</tr>

				<tr class="right">
					<td class="left"><input type="hidden" name="certList" value="B4">在学証明書</td>
					<td><input type="hidden" name="priceList" value="200">200円</td>
					<td><select class="form-select" name="quantityList" id="exampleFormSelect1" onchange="calcSubTotal(3)">
							<option value="0" selected>0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
						</select>
					</td>
					<td class="subtotal">0</td>
				</tr>

				<tr class="right">
					<td class="left"><input type="hidden" name="certList" value="在寮証明書">在寮証明書</td>
					<td><input type="hidden" name="priceList" value="200">200円</td>
					<td><select class="form-select" name="quantityList" id="exampleFormSelect1" onchange="calcSubTotal(4)">
							<option value="0" selected>0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
					</select></td>
					<td class="subtotal">0</td>
				</tr>

				<tr class="right">
					<td class="left"><input type="hidden" name="certList" value="B5">学生証</td>
					<td><input type="hidden" name="priceList" value="300">300円</td>
					<td><select class="form-select" name="quantityList" id="exampleFormSelect1" onchange="calcSubTotal(5)">
							<option value="0" selected>0</option>
							<option value="1">1</option>
					</select></td>
					<td class="subtotal">0</td>
				</tr>

				<tr>
					<th colspan="3">合計金額</th>
					<td class="right" id="sum">0</td>
				</tr>
				
			</table>


			<div class="row p-5">
				<div
					class="card col-md d-lg-flex align-items-center border-0">
					<h3 class=" button-name">
						<button type="submit" name="btnState" value="top" class="baka btn-outline-danger">トップページへ</button>
					</h3>
				</div>

				<div
					class="card col-md d-lg-flex align-items-center border-0">
					<h2 class=" button-name">
						<button type="submit" name="btnState" value="check" class="aho btn-outline-primary">確認</button>
					</h2>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="/R03TeamB/css_js/A02/calc.js"></script>

</html>