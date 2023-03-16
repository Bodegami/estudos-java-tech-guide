
<%
// Java Server Pages = JSP
//Todo o código (scriptlet) é executado no servidor antes de enviar a resposta para o navegador.

// A variavel 'out' do PrintWriter continua disponivel aqui
// out.println(nomeEmpresa);
// '<%= nomeEmpresa' tem a mesma funcao que 'out.println(nomeEmpresa)'

// Expression Language = EL
// ${3 + 3}, ${novaEmpresa}

String nomeEmpresa = (String) request.getAttribute("empresa");
System.out.println("Endpoint: /novaEmpresaCriada.jsp ::: Entrada Request: " + nomeEmpresa);
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<body>

		<c:if test="${not empty empresa}">
			Empresa ${ empresa } cadastrada com sucesso!!
		</c:if>

		<c:if test="${empty empresa}">
			Nenhuma empresa cadastrada.
		</c:if>

	</body>
</html>

