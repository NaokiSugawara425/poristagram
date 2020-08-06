<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ensyu01.jsp</title>
</head>
<body>
<form action="ensyu01_response.jsp" method="POST">
名前：<input type="text" name="text01" size="20" maxlength="18" /><br>
年令：<input type="text" name="text02" size="20" maxlength="18" /><br>
性別：<input type="radio" name="r1" value="男">男
<input type="radio" name="r1" value="女">女<br>
出身地：<select name= "kanto">
<option value = "埼玉県">埼玉県</option>
<option value = "東京都">東京都</option>
<option value = "神奈川県">神奈川県</option>
<option value = "千葉県" selected = "selected">千葉県</option>
<option value = "茨城県">茨城県</option>
<option value = "栃木県">栃木県</option>
<option value = "群馬県">群馬県</option>
</select><br>
趣味（複数選択可）:<br>
<input type="checkbox" name="syumi" value="旅行">旅行
<input type="checkbox" name="syumi" value="ゲーム">ゲーム
<input type="checkbox" name="syumi" value="読書">読書<br>
<input type="checkbox" name="syumi" value="音楽鑑賞">音楽鑑賞
<input type="checkbox" name="syumi" value="その他">その他<br>
アンケート：好きな飲み物<select name = "drink" size ="8" multiple="multiple">
<option value ="コーヒー">コーヒー</option>
<option value ="紅茶">紅茶</option>
<option value ="緑茶">緑茶</option>
<option value ="ジュース">ジュース</option>
<option value ="ビール">ビール</option>
<option value ="日本酒">日本酒</option>
<option value ="ワイン">ワイン</option>
<option value ="生き血">生き血</option>
<option value ="なし">なし</option>
</select>

<input type="submit" value="送信">
</form>
</body>
</html>