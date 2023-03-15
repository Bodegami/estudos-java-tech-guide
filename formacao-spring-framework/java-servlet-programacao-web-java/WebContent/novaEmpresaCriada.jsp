<%
  // Java Server Pages = JSP
  // A variavel 'out' do PrintWriter continua disponivel aqui
  // out.println(nomeEmpresa);
  // '<%= nomeEmpresa' tem a mesma funcao que 'out.println(nomeEmpresa)'

  String nomeEmpresa = "Alura";
  System.out.println(nomeEmpresa);
%>

<html>
<body>
	Empresa <%= nomeEmpresa  %> cadastrada com sucesso!
</body>
</html>

