<%@page import="java.util.ArrayList"%>
<%@page import="model.Post" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    
<!-- TOP ���̾ƿ� -->
<jsp:include page="/layout/topLayout.jsp" flush="false" />

<!-- ����Ʈ ��ü -->
<%
	Post[] list = (Post[]) request.getAttribute("bdList"); // ����Ʈ ����
	int[] paging = (int[]) request.getAttribute("bdPaging"); // ����¡ ����
%>

<!-- ���̺� ���� -->
<table class="table table-hover">
	<thead>
		<tr>
			<th scope="col" class="text-center">����</th>
			<th scope="col" class="text-center">�۾���</th>
			<th scope="col" class="text-center">�ۼ���</th>
			<th scope="col" class="text-center">ī�װ�</th>
			<th scope="col" class="text-center">��ȸ��</th>
		</tr>
	</thead>
	<tbody>

		<%-- ����Ʈ ��� --%>
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
			<!-- �ۼ���, �ۼ���, ī�װ�, ��ȸ�� -->
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

<!-- ����¡ ��� ó�� -->
<p class="text-center">

	<%
		for (int i = paging[0]; i <= paging[1]; i++) {
	%>

	<a class="text-reset" href="/boardChat?requestedPage=<%=i%>"><%=i%></a>&nbsp&nbsp

	<%
		}
	%>
</p>


<!-- ���۾��� ���� �� -->
<form action="/board/boardWriter" method="post">

	<!-- ������ ���� ���� -->
	<input type="hidden" name="bdGroup" value="-1">
	<input type="hidden" name="bdOrder" value="0">
	<input type="hidden" name="bdIndent" value="0">
	<button type="submit" class="btn btn-secondary mb-3">���۾���</button>
</form>


<!-- ����� �޼����� ��ܿ��� ���(�Խù��� ���� ��� ��) -->
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

<!-- Bottom ���̾ƿ� -->
<jsp:include page="/layout/bottomLayout.jsp" flush="false" />