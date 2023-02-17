import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Datas {

	public static void main(String[] args) {
		
		System.out.println("Utilizando o LocalDate para pegar a data atual");
		
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		
		System.out.println("\n------------------------------------------");
		
		
		System.out.println("Calculando a diferenca de uma data para outra");
		
		LocalDate olimpiadasDoRio = LocalDate.of(2024, Month.JUNE, 5);
		int anos = olimpiadasDoRio.getYear() - hoje.getYear();
		System.out.println(anos);
		
		
		
		System.out.println("\n------------------------------------------");
		
		
		System.out.println("Calculando a diferenca de uma data para outra com a classe Period");
		
		Period periodo = Period.between(hoje, olimpiadasDoRio);
		String periodoFormat = "Years: " + periodo.getYears() + ", Months: " + periodo.getMonths() + ", Days: " +  periodo.getDays();
		System.out.println(periodoFormat);
		
		
		System.out.println("\n------------------------------------------");
		
		
		System.out.println("Iterando sobre uma data");
		
		LocalDate proximaOlimpiadas = olimpiadasDoRio.plusYears(4);
		System.out.println(proximaOlimpiadas);
		
		
		System.out.println("\n------------------------------------------");
		
		
		System.out.println("Formatando datas com DateTimeFormatter");
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String valorFormatado = olimpiadasDoRio.format(formatador);
		System.out.println(valorFormatado);
		
		
		System.out.println("\n------------------------------------------");
		
		
		System.out.println("Trabalhando com datas, horas, minutos e segundos");
		
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm:ss");
		System.out.println(agora.format(formatadorComHoras));	
		
		
		System.out.println("\n------------------------------------------");
		
		
		System.out.println("Conhecendo a classe YearMonth e LocalTime");
		
		YearMonth mes = YearMonth.of(agora.getYear(), agora.getMonth());
		System.out.println(mes);
		
		LocalTime intervalo = LocalTime.of(23, 50);
		System.out.println(intervalo);
		
	}
	
}
