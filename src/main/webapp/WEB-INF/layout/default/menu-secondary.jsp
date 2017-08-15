<%@ page pageEncoding="UTF-8" session="true" contentType="text/html" trimDirectiveWhitespaces="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form action="${pageContext.request.contextPath}/logout" method="POST" id="frm-logout">
  <ul class="nav navbar-nav navbar-right">
    <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
      <li class="dropdown ${currentPath eq '/admin' ? 'active' : ' '}">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
          <i class="fa fa-cog fa-fw"></i>&nbsp; <span class=""> Admin</span>
          <span class="caret"></span>
        </a>
        <ul class="dropdown-menu" role="menu">
          <li><a href="<c:url value="/admin/cities"/>">Cities</a></li>
        </ul>
      </li>
    </sec:authorize>

    <sec:authorize access="!isAuthenticated()">
      <li>
        <a href="<c:url value="/login"/>">
          <i class="fa fa-sign-in" aria-hidden="true"></i>
          <span class=""> &nbsp; Sign In</span>
        </a>
      </li>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
      <li>
        <a href="#" onclick="document.getElementById('frm-logout').submit();">
          <i class="fa fa-sign-out" aria-hidden="true"></i>
          <span class=""> &nbsp; Sign Out</span>
        </a>
      </li>
    </sec:authorize>
  </ul>
</form:form>
