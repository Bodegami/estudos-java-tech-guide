package br.com.bytebank.banco.test;

import br.com.bytebank.banco.especial.ContaEspecial;
import br.com.bytebank.banco.modelo.*;

//br.com.bytebank.banco.test.TesteContas
public class TesteContas {

	//java.lang.String
	public static void main(String[] args) throws SaldoInsuficienteException {
		
		ContaEspecial ce = new ContaEspecial(123, 5555);
		
		//Full Qualified Name (FQN) == br.com.bytebank.banco.modelo.ContaCorrente
		ContaCorrente cc = new ContaCorrente(111, 111);
		cc.deposita(100.0);
		
		ContaPoupanca cp = new ContaPoupanca(222, 222);
		cp.deposita(200.0);

		cc.transfere(10.0, cp);
		
		System.out.println("CC " + cc.getSaldo());
		System.out.println("CP " + cp.getSaldo());

	}

}
