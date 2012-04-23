<%@ include file="/header.jsp" %> 

<script>
	$(document).ready(function(){ 
		alert("As you can see, the link no longer took you to jquery.com");
	});
</script>

<form action="/depot/produtos" method="post">
	<input type="hidden" name="produto.id" value="${produto.id}" ></input>
	Título:&nbsp;<input type="text" size="30" name="produto.titulo" value="${produto.titulo}" ></input><br/>
	Descrição:&nbsp;<textarea rows="3" cols="30" name="produto.descricao" >${produto.descricao}</textarea><br/>
	
	<c:choose>
		<c:when test="${!empty produto.id}">
		    <button type="submit" name="_method" value="PUT">
		   		<span class="ui-button-text">Salvar</span>
			</button>
		    <button type="submit" name="_method" value="DELETE">
		   		<span class="ui-button-text">Excluir</span>
			</button>
		</c:when>
		<c:otherwise>
		    <button type="submit">
		   		<span class="ui-button-text">Criar</span>
			</button>
		</c:otherwise>
	</c:choose>
</form>

<form action="/depot/produtos" method="get">
    <button id="voltar" type="submit">
   		<span class="ui-button-text">Voltar</span>
	</button>
</form>



<%@ include file="/footer.jsp" %> 