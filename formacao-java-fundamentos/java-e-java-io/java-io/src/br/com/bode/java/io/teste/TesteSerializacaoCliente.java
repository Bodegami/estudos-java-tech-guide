package br.com.bode.java.io.teste;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TesteSerializacaoCliente {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//Recebemos uma NoSerializableException quando a classe não assina o contrato de serializacao
		

//		Cliente cliente = new Cliente();
//		cliente.setNome("Renato");
//		cliente.setProfissao("Dev");
//		cliente.setCpf("12345678901");
//		
//		
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cliente.bin"));	
//		oos.writeObject(cliente);
//		oos.close();
		
		//deserializando um objeto
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cliente.bin"));
		Cliente cliente = (Cliente) ois.readObject();
		ois.close();
		System.out.println(cliente.getNome());
		System.out.println(cliente.getProfissao());
		

	}

}
