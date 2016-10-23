<%@ page language="java" import="java.io.*" contentType="text/html" %>
<%@ include file="../WEB-INF/app/zzhead.jsp" %>

<div class="error">There was a problem processing your request.</div>
<div class="error">If you require further assistance, please take a screenshot of this error and contact the support
team</div>

<hr/>

<table border="1" width="60%" align="center">
	<thead>
		<tr>
			<th>Message:</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${message}</td>
		</tr>
	</tbody>
</table>

<%@ include file="../WEB-INF/app/zztail.jsp" %>