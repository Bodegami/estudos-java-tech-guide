<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	  Lista de empresas: <br />
	  
		<ul>
			<c:forEach items="${empresas}" var="empresa">
				<li>${empresa.nome}</li>
			</c:forEach>
		</ul>
	</body>
</html>
