<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/jsp/fragments/header.jsp"%>
<body>
	<div id="main_unit">
		<div id="buttons_header">
			<ctg:info-role role="${role}" />
		</div>
		<div id="buttons_header">
			<jsp:include page="/jsp/fragments/locale.jsp" />
		</div>
		<div id="header_section"></div>
		<div id="right_section">
			<div id="user_unit">
				<jsp:include page="/jsp/fragments/user_unit.jsp" />
			</div>
			<jsp:include page="/jsp/fragments/category.jsp" />
		</div>
		<div id="unit">
			<br>
			<table id="goods_description">
				<c:forEach var="goods" items="${goods}">
					<tr>
						<td width="200px" align="center"><img alt="${goods.imgGoods}"
							src="http://localhost:8080/InternetShop/${goods.imgGoods}"
							width="100px"></td>
						<td align="left" colspan="2">${goods.nameGoods}<br> <br>
							${goods.description}
						</td>
					</tr>
					<tr>
						<td align="right" colspan="2"><form action="controller"
								method="post">
								<input type="hidden" name="page" value="more" /> <input
									type="hidden" name="id" value="${goods.numberGoods}" /> <input
									type="submit"
									value='<fmt:message key="button.more-goods"></fmt:message>'>
							</form> <br>
							<hr> <br></td>
					</tr>
				</c:forEach>
			</table>
			<center>
				<table>
					<tr>
						<c:forEach begin="1" end="${pages}" varStatus="loop">
							<td><form action="controller" method="post">
									<input type="hidden" name="page" value="page_catalog_user" /><input
										type="hidden" name="type" value="${type}" /><input
										type="hidden" name="numberPage" value="${loop.index}" /> <input
										type="submit" id="numberPage" value="${loop.index}" />
								</form></td>
						</c:forEach>
					</tr>
				</table>
			</center>
		</div>
		<div id="clearfix"></div>
	</div>
	<div id="footer_section">
		<jsp:include page="/jsp/fragments/footer.jsp" />
	</div>
</body>
</html>