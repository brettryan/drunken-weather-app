<%@ page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="jumbotron m-y-1">
  <h1><spring:message code="home.heading"/></h1>
  <p>Welcome to Drunken Weather.</p>
  <p>
    <a class="btn btn-primary btn-lg" href="#" role="button">Learn More</a>
  </p>
</div>
