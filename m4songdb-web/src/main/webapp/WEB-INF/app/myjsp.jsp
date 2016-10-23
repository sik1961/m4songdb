<%@ page language="java" contentType="text/html" %>
<%@ include file="zzhead.jsp"%>

<style type="text/css">
select.selStd {
    width: 275px;
}
</style>

<div style="font: sans serif">
	<br />
	<table align="left">
		<tr>
			<td>
				<div style="background-color: #FFFFFF">
					<table border="1" align="center" width="100%" cellspacing="0">
						<tr>
							<td>
								Name:
							</td>
							<td>
								<c:out value="${name}"/>
							</td>
						</tr>
						<tr>
							<td>
								Job:
							</td>
							<td>
								<c:out value="${job}"/>
							</td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
</div>
<%@ include file="zztail.jsp" %>
