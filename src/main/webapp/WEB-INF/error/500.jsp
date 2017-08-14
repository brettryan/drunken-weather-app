<%@ page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ex" value="${requestScope['javax.servlet.error.exception']}"/>

<h3><c:if test="${!empty(ex.message)}"><c:out value="${ex.message}"/></c:if></h3>

  <p>An internal error has occurred preventing your request from processing.
    Please contact the system administrator alerting them to the problem.</p>

  <p>The following trace information may be helpful for support engineers in
    determining the cause of the problem. Forward the below information to your
    support staff.</p>

<!--
  <pre>
<%
    if (exception != null) {
        try (StringWriter sw = new StringWriter();
             PrintWriter pw = new PrintWriter(sw)) {
            pw.print(exception.getMessage() + "\n");
            exception.printStackTrace(pw);
            out.print(sw);
        }
    }
%>
</pre>
-->