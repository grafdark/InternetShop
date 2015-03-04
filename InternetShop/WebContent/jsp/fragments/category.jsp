<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="/jsp/fragments/header.jsp"%>
<script type="text/javascript">
	$(function() {
		var offset = $("#fixed").offset();
		var topPadding = 15;
		$(window).scroll(function() {
			if ($(window).scrollTop() > offset.top) {
				$("#fixed").stop().animate({
					marginTop : $(window).scrollTop() - offset.top + topPadding
				});
			} else {
				$("#fixed").stop().animate({
					marginTop : 0
				});
			}
			;
		});
	});
</script>
<body>
	<div id="fixed">
		<div id="category_header">
			<fmt:message key="category.head"></fmt:message>
		</div>
		<div id="categories">
			<form action="controller" method="post">
				<input type="hidden" name="page" value="category" /> <input
					type="hidden" name="num" value="0" /> <input
					style="text-align: left; padding-left: 10px;" type="submit"
					id="right_section"
					value='<fmt:message key="category.mobile-phone"></fmt:message>' />
			</form>
			<form action="controller" method="post">
				<input type="hidden" name="page" value="category" /> <input
					type="hidden" name="num" value="1" /> <input
					style="text-align: left; padding-left: 10px;" type="submit"
					id="right_section"
					value='<fmt:message key="category.foto"></fmt:message>' />
			</form>
			<form action="controller" method="post">
				<input type="hidden" name="page" value="category" /> <input
					type="hidden" name="num" value="2" /> <input
					style="text-align: left; padding-left: 10px;" type="submit"
					id="right_section"
					value='<fmt:message key="category.tablet"></fmt:message>' />
			</form>
			<form action="controller" method="post">
				<input type="hidden" name="page" value="category" /> <input
					type="hidden" name="num" value="3" /> <input
					style="text-align: left; padding-left: 10px;" type="submit"
					id="right_section"
					value='<fmt:message key="category.notebook"></fmt:message>' />
			</form>
			<form action="controller" method="post">
				<input type="hidden" name="page" value="category" /> <input
					type="hidden" name="num" value="4" /> <input
					style="text-align: left; padding-left: 10px;" type="submit"
					id="right_section"
					value='<fmt:message key="category.ebooks"></fmt:message>' />
			</form>
			<form action="controller" method="post">
				<input type="hidden" name="page" value="category" /> <input
					type="hidden" name="num" value="5" /> <input
					style="text-align: left; padding-left: 10px;" type="submit"
					id="right_section"
					value='<fmt:message key="category.players"></fmt:message>' />
			</form>
			<form action="controller" method="post">
				<input type="hidden" name="page" value="category" /> <input
					type="hidden" name="num" value="6" /> <input
					style="text-align: left; padding-left: 10px;" type="submit"
					id="right_section"
					value='<fmt:message key="category.console"></fmt:message>' />
			</form>
		</div>
	</div>
</body>
</html>