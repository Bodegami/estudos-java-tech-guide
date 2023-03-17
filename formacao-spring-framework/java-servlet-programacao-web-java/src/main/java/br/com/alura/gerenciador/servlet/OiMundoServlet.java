package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * Repare que em nenhum momento criamos um metodo main na aplicacao,
	 * ainda assim quando subimos a aplicacao e chamamos algum endpoint
	 * mapeado, ela executa perfeitamente.
	 * 
	 * Isso acontece pq no mundo Java servlet é um objeto e quem cria
	 * uma instância desse objeto é o Tomcat.
	 * 
	 * O Tomcat também é conhecido como Servlet-container ou middleware,
	 * ou seja, ele recebe a requisicao HTTP e depois ele chama o objeto 
	 * servlet passando os dados da requisição. Ele exerce um papel de 
	 * intermediario.
	 * 
	 * Outro detalhe é que quando subimos a aplicacao, o Tomcat não cria
	 * nem objeto servlet. Ele só vai criar quando receber alguma requisicao 
	 * e identificar qual o servlet que tem que criar.
	 * Além disso, depois que ele recebe uma requisicao e chama o servlet 
	 * correspondente, ele deixa esse objeto em memoria para que as proximas
	 * requisicoes desse servlet possam aproveitar esse objeto que está em
	 * memoria (Pattern Singleton).
	 * 
	 * Essa ideia de que o Tomcat ser responsavel por criar o objeto Servlet
	 * de forma que precisamos nos preocupar apenas com as classes e as 
	 * regras de negocio, é conhecido como IOC (Inversão de Controle).
	 * 
	 */
	
	public OiMundoServlet() {
		System.out.println("Criando Oi Mundo Servlet!");
	}
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Oi mundo, parabens! Você escreveu o primeiro servlets.");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("O servlet OiMundoServlet foi chamado");
	}
	
}
