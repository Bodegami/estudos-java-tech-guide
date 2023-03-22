package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter(urlPatterns = "/entrada")
public class MonitoramentoFilter implements Filter {
	
	//Para o Tomcat, podemos utilizar a implementacao default da interface
	//Mas com o Jetty, é necessário reimplementar
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	//Para o Tomcat, podemos utilizar a implementacao default da interface
	//Mas com o Jetty, é necessário reimplementar
	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("MonitoramentoFilter");

		long antes = System.currentTimeMillis();
		
		String acao = request.getParameter("acao");
		
		// Precisamos chamar o chain.doFilter(request, response) para continuar a execucao da 
		// requisicao, do contrário a requisicao ficara parada
		// Alem disso, repare que a url de mapeamento é a mesma do servlet, porem como o filter
		// é uma camada que fica na frente do sevlet, ele sempre será o primeiro a ser executado
		// Outro ponto é que que quando utilizamos a anotacao @WebFilter, não temos garantia da
		// ordem de execucao dos filtros, caso fosse preciso garantir a ordem, ai teriamos que
		// implementar o filtro via web.xml
		chain.doFilter(request, response);
		
		long depois = System.currentTimeMillis();
		long tempoExecucao = (depois - antes);
		System.out.printf("Tempo de execução da ação: %s -> %d ms \n", acao, tempoExecucao);
		
	}

}
