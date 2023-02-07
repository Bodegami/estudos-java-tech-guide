
public class TesteConexao {

	public static void main(String[] args) {
		
		
		// forma mais atualizada
		try (Conexao conexao = new Conexao()) {
			conexao.leDados();
		} catch(Exception ex) {
			System.out.println("Deu erro na conexao");
		}
		

		// ------------------------------------------------
		// Um try, sempre exige UM catch ou UM finally
//		Conexao con = null;
//		try {
//			con = new Conexao();
//			con.leDados();
//		} catch (IllegalStateException e) {
//			System.out.println("Deu erro na conexao");
//		} finally {
//			System.out.println("finally..");
//			if (con != null) {
//				con.close();
//			}
//		}
		
	}
	
}
