<%@page import="java.util.ArrayList"%>
<%@page import="model.Post" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    
<!-- TOP 레이아웃 -->
<jsp:include page="/layout/topLayout.jsp" flush="false" />

<!-- 리스트 객체 -->
<%
	Post[] list = (Post[]) request.getAttribute("bdList"); // 리스트 정보
	int[] paging = (int[]) request.getAttribute("bdPaging"); // 페이징 정보
%>

<!-- 테이블 시작 -->
<table class="table table-hover">
	<thead>
		<tr>
			<th scope="col" class="text-center">제목</th>
			<th scope="col" class="text-center">글쓴이</th>
			<th scope="col" class="text-center">작성일</th>
			<th scope="col" class="text-center">카테고리</th>
			<th scope="col" class="text-center">조회수</th>
		</tr>
	</thead>
	<tbody>

		<%-- 리스트 출력 --%>
		<%
			if (list != null && paging != null) {
				for (int i = 0; i < list.length; i++) {
		%>

		<tr>
			<td style="width: 60%">
				<a class="text-reset"
					href="board/requestBdCont?requestBdNum=<%=list[i].getPostNum()%>"
				> <%=list[i].getTitle()%></a>
			</td>
			<!-- 작성자, 작성일, 카테고리, 조회수 -->
			<td style="width: 10%" class="text-center"><%=list[i].getWriter()%></td>
			<td style="width: 20%" class="text-center"><%=list[i].getWriteDate()%></td>
			<td style="width: 20%" class="text-center"><%=list[i].getCategory()%></td>
			<td style="width: 10%" class="text-center"><%=list[i].getVisitCount()%></td>
		</tr>

		<%
			}
		%>

	</tbody>
</table>
<%
	}
%>

<!-- 페이징 목록 처리 -->
<p class="text-center">

	<%
		for (int i = paging[0]; i <= paging[1]; i++) {
	%>

	<a class="text-reset" href="/boardChat?requestedPage=<%=i%>"><%=i%></a>&nbsp&nbsp

	<%
		}
	%>
</p>


<!-- 새글쓰기 누를 때 -->
<form action="/board/boardWriter" method="post">

	<!-- 새글의 계층 정보 -->
	<input type="hidden" name="bdGroup" value="-1">
	<input type="hidden" name="bdOrder" value="0">
	<input type="hidden" name="bdIndent" value="0">
	<button type="submit" class="btn btn-secondary mb-3">새글쓰기</button>
</form>


<!-- 출력할 메세지가 담겨왔을 경우(게시물이 없을 경우 등) -->
<%
	Object obj = request.getAttribute("bdListMsg");
	if (obj != null) {
		String msg = (String) obj;
%>
<div class="container my-3">
	<div class="row">
		<div class="col"></div>
		<div class="col-md-auto"><%=msg%></div>
		<div class="col"></div>
	</div>
</div>
<%
	}
%>

<!-- Bottom 레이아웃 -->
<jsp:include page="/layout/bottomLayout.jsp" flush="false" />