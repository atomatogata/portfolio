<h1>ページの一覧</h1>

<c:forEach var="wikiPage" items="${list}">
  <c:url value="/refer" var="url">
    <c:param name="name" value="${wikiPage.name}"/>
  </c:url>
  <li><a href="${url}">${wikiPage.name}</a><br>
</c:forEach>
<c:out value="今日わんこ"/>