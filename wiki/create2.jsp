<h1>${param.name}の作成</h1>

<form action="create">

  <input type="hidden" name="cmd" value="create">
  <input type="hidden" name="name" value="${param.name}">

  <textarea rows="15" cols="60" name="content"></textarea>

  <br>
  <input type="submit" value=" 作成 ">
  <input type="BUTTON" value="キャンセル" onclick="location.href='refer'">

</form>