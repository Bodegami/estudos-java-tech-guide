package bytebank;

public class TestaMetodos {

	public static void main(String[] args) {
		
		Conta contaDoRenato = new Conta();
		contaDoRenato.saldo = 100;
		contaDoRenato.deposita(50);
		System.out.println(contaDoRenato.saldo);
		
		boolean conseguiuRetirar = contaDoRenato.saca(20);
		System.out.println(contaDoRenato.saldo);
		System.out.println(conseguiuRetirar);
		
		Conta contaDaLiana = new Conta();
		contaDaLiana.deposita(1000);
		
		boolean sucessoTransferencia = contaDaLiana.transfere(3000, contaDoRenato);
		
		if (sucessoTransferencia) {
			System.out.println("transferencia com sucesso!");
		} else {
			System.out.println("faltou dinheiro!");
		}
		
		System.out.println(contaDaLiana.saldo);
		System.out.println(contaDoRenato.saldo);
		
		contaDoRenato.titular = "renato";
		System.out.println(contaDoRenato.titular);
		
		System.out.println(contaDaLiana.titular);

	}

}
