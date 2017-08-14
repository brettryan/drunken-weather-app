<%@page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<tiles:insertAttribute name="menu" ignore="true"/>

<div class="container" role="main">
  <tiles:importAttribute ignore="true" name="debugView"/>
  <c:if test="${not empty debugView}">
    <jsp:include page="/WEB-INF/views/bs-view-help.jsp"/>
  </c:if>
  <tiles:importAttribute name="heading" ignore="true"/>
  <c:if test="${not empty heading}">
    <h1><spring:message code="${heading}" text="${heading}" /></h1>
  </c:if>
  <c:if test="${not empty errorMessage}">
    <div class="alert alert-danger alert-dismissible" role="alert">
      <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      <strong>Error!</strong> <c:out value="${errorMessage}"/>
    </div>
  </c:if>
  <tiles:importAttribute name="body" ignore="true"/>
  <c:forEach var="x" items="${body}">
    <tiles:insertAttribute value="${x}" flush="true" />
  </c:forEach>
</div>
<tiles:insertAttribute name="footer" ignore="true"/>
