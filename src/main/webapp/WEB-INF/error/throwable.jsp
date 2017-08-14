<%@page isErrorPage="true"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@page import="javax.servlet.http.Cookie"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="ex" value="${requestScope['javax.servlet.error.exception']}"/>
<p>An internal error has occurred.</p>
<a href="<c:url value="/"/>">Return to application home</a>
<%--
<h3>Reason</h3>
<c:if test="${!empty(ex.message)}">
  <pre><c:out value="${ex.message}"/></pre>
</c:if>
<h3>Stack Trace</h3>
--%>
<!--
<pre><%
    StringWriter stringWriter = new StringWriter();
    PrintWriter printWriter = new PrintWriter(stringWriter);
    exception.printStackTrace(printWriter);
    out.println(stringWriter);
    printWriter.close();
    stringWriter.close();
  %></pre>
  <%--
    <c:forEach var="trace" items="${pageContext.exception.stackTrace}">
      ${trace}</c:forEach>
  --%>
<h3>Cookies:</h3>
<pre><%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            out.println(cookies[i].getName() + "=[" + cookies[i].getValue() + "]");
        }
    }
  %></pre>
-->
