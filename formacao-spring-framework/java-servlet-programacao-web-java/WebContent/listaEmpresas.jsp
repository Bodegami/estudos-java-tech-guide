<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
	// Com o JSTL simplicamos bastante a forma de iterar sobre um laço de repetição
	// além disso, note que para imprimir o nome da variavel empresa dentro do EL,
	// chamamo "empresa.nome". Por de baixo dos panos ele vai chamar o metodo 
	// empresa.getNome().

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
	<body>
	  
	  <c:if test="${not empty empresa}">
			Empresa ${ empresa } cadastrada com sucesso!!
	  </c:if>
	
	
	  Lista de empresas: <br />
	  
		<ul>
			<c:forEach items="${empresas}" var="empresa">
				<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" var="dataFormatada"/>
				
				<li>
					${empresa.nome} ::: ${dataFormatada} - <a href="/gerenciador/removeEmpresa?id=${empresa.id}">remove</a>
				</li>
			</c:forEach>
		</ul>
	</body>
</html>
