<%@page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<c:url value="/" var="pathHome"/>
<spring:message code="error.404.message" htmlEscape="false" arguments="${pathHome}"/>
