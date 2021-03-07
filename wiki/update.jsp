<h1>${wikiPage.name}の編集</h1>

<form action="update">
  <input type="hidden" name="cmd" value="update">
  <input type="hidden" name="name" value="${wikiPage.name}">

  <textarea rows="15" cols="60" name="content">${wikiPage.content}</textarea>

  <br>
  <input type="submit" value=" 更新 ">
  <input type="submit" value=" 削除 " onclick="cmd.value='delete'">
  <input type="button" value="キャンセル" onclick="location.hef='refer'">

</form>