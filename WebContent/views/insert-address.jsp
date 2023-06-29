<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h2 style="text-align:center; margin-top:30px">住所登録</h2>

<div class="regist-address-div">

	<div class="regist-address-form-div">
		<form action="/ShoppingSite/jp.co.aforce.servlet/insert-address" method="post">
			<table class="regist-address-table">
				<tr>
					<td style="padding:15px 0 15px 0" width="150px">郵便番号</td>
					<td>
						<input type="text" name="post_code1" pattern="^[0-9]{3}$" size="5px" style="padding:3px" required>
						- <input type="text" name="post_code2" pattern="^[0-9]{4}$" size="5px" style="padding:3px" required>
					</td>
				</tr>
				<tr>
					<td style="padding:15px 0 15px 0">都道府県</td>
					<td><select name="state" style="padding:3px" required>
						<option value="">選んでください</option>
						<option value="北海道">北海道</option>
						<option value="青森県">青森県</option>
						<option value="岩手県">岩手県</option>
						<option value="宮城県">宮城県</option>
						<option value="秋田県">秋田県</option>
						<option value="山形県">山形県</option>
						<option value="福島県">福島県</option>
						<option value="茨城県">茨城県</option>
						<option value="栃木県">栃木県</option>
						<option value="群馬県">群馬県</option>
						<option value="埼玉県">埼玉県</option>
						<option value="千葉県">千葉県</option>
						<option value="東京都">東京都</option>
						<option value="神奈川県">神奈川県</option>
						<option value="新潟県">新潟県</option>
						<option value="富山県">富山県</option>
						<option value="石川県">石川県</option>
						<option value="福井県">福井県</option>
						<option value="山梨県">山梨県</option>
						<option value="長野県">長野県</option>
						<option value="岐阜県">岐阜県</option>
						<option value="静岡県">静岡県</option>
						<option value="愛知県">愛知県</option>
						<option value="三重県">三重県</option>
						<option value="滋賀県">滋賀県</option>
						<option value="京都府">京都府</option>
						<option value="大阪府">大阪府</option>
						<option value="兵庫県">兵庫県</option>
						<option value="奈良県">奈良県</option>
						<option value="和歌山県">和歌山県</option>
						<option value="鳥取県">鳥取県</option>
						<option value="島根県">島根県</option>
						<option value="岡山県">岡山県</option>
						<option value="広島県">広島県</option>
						<option value="山口県">山口県</option>
						<option value="徳島県">徳島県</option>
						<option value="香川県">香川県</option>
						<option value="愛媛県">愛媛県</option>
						<option value="高知県">高知県</option>
						<option value="福岡県">福岡県</option>
						<option value="佐賀県">佐賀県</option>
						<option value="長崎県">長崎県</option>
						<option value="熊本県">熊本県</option>
						<option value="大分県">大分県</option>
						<option value="宮崎県">宮崎県</option>
						<option value="鹿児島県">鹿児島県</option>
						<option value="沖縄県">沖縄県</option>
					</select></td>
				</tr>
				<tr>
					<td style="padding:15px 0 15px 0">市区町村</td>
					<td>
						<input type="text" name="city" size="28px" style="padding:3px" required>
					</td>
				</tr>
				<tr>
					<td style="padding:15px 0 15px 0">番地以降</td>
					<td>
						<input type="text" name="address_line" size="28px" style="padding:3px" required>
					</td>
				</tr>
				<tr>
					<td style="padding:15px 0 15px 0">受取人氏名</td>
					<td>
						<input type="text" name="receiver_last_name" size="10px" style="padding:3px" required>
						 <input type="text" name="receiver_first_name" size="10px" style="padding:3px" required><br>
					</td>
				</tr>
			</table>
			<div style="text-align:center; padding:30px">
				<button type="button" class="back-btn" onclick="history.back()">戻る</button>
				<input type="submit" name="regist" class="next-btn" value="登録" onClick="return insert_address_check()">
			</div>
		</form>
	</div>

</div>

<%@ include file="footer.jsp" %>