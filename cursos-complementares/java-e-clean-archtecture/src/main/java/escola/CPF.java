package escola;

public class CPF {
	
	private String registro;

	public CPF(String registro) {
		//"(^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$)|(^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$)"
		if (registro == null || !registro.matches("^\\d{3}[\\.]?\\d{3}[\\.]?\\d{3}[-]?\\d{2}$")) {
			throw new IllegalArgumentException("CPF invalido!");
		}
		
		this.registro = registro;
	}

	public String getRegistro() {
		return registro;
	}

}
