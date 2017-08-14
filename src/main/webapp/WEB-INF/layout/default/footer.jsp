<%@page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<fmt:setBundle basename="version"/>
<fmt:message key="version" var="version"/>
<fmt:message key="build.number" var="buildNumber"/>
<fmt:message key="build.tag" var="buildTag"/>
<fmt:message key="build.date" var="buildDate"/>

<footer class="footer hidden-xs">
  <div class="container">
    <p class="text-muted"><spring:message code="label.copyright"/> | <c:out value="${version}"/> - <c:out value="${buildDate}"/></p>
  </div>
</footer>
