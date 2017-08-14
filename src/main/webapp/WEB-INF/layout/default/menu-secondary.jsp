<%@ page pageEncoding="UTF-8" session="true" contentType="text/html" trimDirectiveWhitespaces="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form action="${pageContext.request.contextPath}/logout" method="POST" id="frm-logout">
  <ul class="nav navbar-nav navbar-right">
    <tiles:importAttribute name="secondaryMenu" ignore="true" />
    <sec:authorize access="!isAuthenticated()">
      <li>
        <a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
          <span class=""> &nbsp; Log In</span>
        </a>
      </li>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
      <li>
        <a href="#" onclick="document.getElementById('frm-logout').submit();">
          <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
          <span class=""> &nbsp; Log Out</span>
        </a>
      </li>
    </sec:authorize>
  </ul>
</form:form>
