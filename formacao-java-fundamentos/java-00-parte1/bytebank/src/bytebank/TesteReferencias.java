package bytebank;

public class TesteReferencias {

	public static void main(String[] args) {

		Conta primeiraConta = new Conta();
		primeiraConta.saldo = 300;

		System.out.println("saldo da primeira: " + primeiraConta.saldo);

		Conta segundaConta = primeiraConta;

		System.out.println("saldo da segunda: " + primeiraConta.saldo);

		segundaConta.saldo += 100;
		System.out.println("saldo da segunda: " + primeiraConta.saldo);

		System.out.println("saldo da primeira: " + primeiraConta.saldo);

		if (primeiraConta == segundaConta) {
			System.out.println("são a mesmissima conta");
		}

		System.out.println(primeiraConta);
		System.out.println(segundaConta);

	}

}
