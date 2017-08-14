<%@page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar">
        <span class="glyphicon glyphicon-th"></span> Menu
      </button>
      <a class="${currentPath eq '/' ? 'active' : ''} navbar-brand" href="<c:url value="/"/>">Weather</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <tiles:insertAttribute name="menu-primary" ignore="true" />
      <tiles:insertAttribute name="menu-secondary" ignore="true" />
    </div>
  </div>
</nav>
