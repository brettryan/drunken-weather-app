<%@ page pageEncoding="UTF-8" session="true" contentType="text/html" trimDirectiveWhitespaces="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://drunkendev.com/taglib/app-config" prefix="conf" %>

<c:set var="currentPath" value="${requestScope['javax.servlet.forward.servlet_path']}"/>

<sec:authorize access="hasRole('ROLE_ADMIN')">
  <ul class="nav navbar-nav">
    <li class="${fn:startsWith(currentPath, '/admin/cities') ? 'selected' : ' '}"><a href="<c:url value="/admin/cities"/>">Cities</a></li>
    <li><a href="<c:url value="/"/>">Exit Admin</a></li>
  </ul>
</sec:authorize>
