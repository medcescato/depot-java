<%@ include file="/header.jsp" %> 
	 
<p><strong>Produtos:</strong></p> 

<form action="/depot/produtos/novo" method="get">
	<button class="ui-button ui-button-text-only ui-widget ui-state-default ui-corner-all">
	   <span class="ui-button-text">Novo</span>
	</button>
</form>

<ul>
	<c:forEach items="${produtoList}" var="produto">
		<li><a href="/depot/produtos/${produto.id}" >${produto.titulo}</a>: ${produto.descricao}</li>
	</c:forEach>
</ul>

<%@ include file="/footer.jsp" %> 