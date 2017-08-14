<%@page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@taglib uri="http://drunkendev.com/taglib/app-config" prefix="conf" %>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags --%>
<meta name="author" content="Drunken Dev.">
<meta name="description" content="<spring:message code="site.description"/>">
<sec:csrfMetaTags />
<tiles:importAttribute ignore="true" name="title" toName="title"/>
<title><spring:message code="${title}" text="${title}" /></title>
<link rel="shortcut icon" type="image/x-icon" href="<c:url value="/static/img/favicon.ico"/>" />
<!--<link href=/apple-touch-icon.png rel=apple-touch-icon>-->
<tiles:importAttribute name="stylesheets" toName="stylesheets" ignore="true"/>
<c:forEach var="x" items="${stylesheets}">
  <link rel="stylesheet" href="<c:url value="${x}"/>">
</c:forEach>

<%-- Place jQuery here to allow jQuery init within views. --%>
<script src="<c:url value="/static/js/jquery-3.1.0.min.js"/>"></script>
