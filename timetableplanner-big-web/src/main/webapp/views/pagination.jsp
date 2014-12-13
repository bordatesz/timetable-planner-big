<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/views/import.jsp"%>

<c:url var="firstUrl" value="/${page.pageName}/1" />
<c:url var="lastUrl" value="/${page.pageName}/${page.totalPages}" />
<c:url var="prevUrl" value="/${page.pageName}/${page.currentIndex - 1}" />
<c:url var="nextUrl" value="/${page.pageName}/${page.currentIndex + 1}" />

<div class="text-center">
  <ul class="pagination">
    <c:choose>
      <c:when test="${page.currentIndex == 1 || page.currentIndex > page.totalPages}">
        <li class="disabled"><a href="#">&lt;&lt;</a></li>
        <li class="disabled"><a href="#">&lt;</a></li>
      </c:when>
      <c:otherwise>
        <li><a href="${firstUrl}">&lt;&lt;</a></li>
        <li><a href="${prevUrl}">&lt;</a></li>
      </c:otherwise>
    </c:choose>
    <c:forEach var="i" begin="${page.beginIndex}" end="${page.endIndex}">
      <c:url var="pageUrl" value="/${page.pageName}/${i}" />
      <c:choose>
        <c:when test="${i == page.currentIndex}">
          <li class="active"><a href="${pageUrl}"><c:out
                value="${i}" /></a></li>
        </c:when>
        <c:otherwise>
          <li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
        </c:otherwise>
      </c:choose>
    </c:forEach>
    <c:choose>
      <c:when test="${page.currentIndex == page.totalPages || page.currentIndex > page.totalPages}">
        <li class="disabled"><a href="#">&gt;</a></li>
        <li class="disabled"><a href="#">&gt;&gt;</a></li>
      </c:when>
      <c:otherwise>
        <li><a href="${nextUrl}">&gt;</a></li>
        <li><a href="${lastUrl}">&gt;&gt;</a></li>
      </c:otherwise>
    </c:choose>
  </ul>
</div>
