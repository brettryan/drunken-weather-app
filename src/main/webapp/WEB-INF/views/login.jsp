<%@ page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:set var="error" value="${sessionScope.SPRING_SECURITY_LAST_EXCEPTION}"/>

<c:if test="${param.error != null}">
  <div role="alert" class="alert alert-danger alert-dismissible fade in">
    <button aria-label="Close" data-dismiss="alert" class="close" type="button"><span aria-hidden="true">×</span></button>
    <strong>Your login attempt was not successful!</strong> ${error.message}
  </div>
</c:if>

<form:form cssStyle="margin-top: 3em"
           cssClass="form-horizontal" name="f"
           servletRelativeAction="/login"
           method="POST">
  <div class="form-group">
    <div class="col-sm-4 col-sm-offset-4">
      <h1>Login</h1>
    </div>
  </div>
  <div class="form-group">
    <label for="username" class="sr-only"><spring:message code="login.user.label"/></label>
    <div class="col-sm-4 col-sm-offset-4">
      <input name="username" class="form-control" id="username" placeholder="<spring:message code="login.user.label"/>" type="text"
             autocorrect="off" autocapitalize="off"
             required autofocus>
    </div>
  </div>
  <div class="form-group">
    <label for="password" class="sr-only"><spring:message code="login.pass.label"/></label>
    <div class="col-sm-4 col-sm-offset-4">
      <input name="password" class="form-control" id="password" placeholder="<spring:message code="login.pass.label"/>" type="password" required>
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-4 col-sm-offset-4">
      <button class="btn btn-default" type="submit"><spring:message code="login.label"/></button>
    </div>
  </div>
</form:form>
