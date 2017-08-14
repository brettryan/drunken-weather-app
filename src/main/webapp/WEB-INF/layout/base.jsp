<%@page pageEncoding="UTF-8" session="true" contentType="text/html" trimDirectiveWhitespaces="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <tiles:importAttribute name="head" toName="head" ignore="true"/>
    <c:forEach var="x" items="${head}">
      <tiles:insertAttribute value="${x}" flush="true" />
    </c:forEach>
  </head>
  <body>
    <tiles:importAttribute name="body-start" toName="bodyStart" ignore="true"/>
    <c:forEach var="x" items="${bodyStart}">
      <tiles:insertAttribute value="${x}" flush="true" />
    </c:forEach>
    <tiles:importAttribute name="main" toName="main" ignore="true"/>
    <c:forEach var="x" items="${main}">
      <tiles:insertAttribute value="${x}" flush="true" />
    </c:forEach>
    <tiles:importAttribute name="body-end" toName="bodyEnd" ignore="true"/>
    <c:forEach var="x" items="${bodyEnd}">
      <tiles:insertAttribute value="${x}" flush="true" />
    </c:forEach>
  </body>
</html>
