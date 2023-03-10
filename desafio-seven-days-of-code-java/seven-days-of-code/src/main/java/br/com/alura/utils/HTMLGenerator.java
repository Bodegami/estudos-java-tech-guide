package br.com.alura.utils;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import br.com.alura.contracts.Content;

public class HTMLGenerator {

	private Writer writer;

	public HTMLGenerator(Writer writer) {
		this.writer = writer;
	}
	
	public void generate(List<? extends Content> movies) throws IOException {

		writer.append("<html>\n");
		writer.append(createHeader());
		writer.append("    <body>\n");
		movies.forEach(m -> {
			try {
				writer.append("  " + createDivTemplate(m));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		writer.append("    </body>\n");
		writer.append("</html>");
		writer.flush();
		writer.close();
	}
	
	private String createHeader() {
		return """
					<head>
						<meta charset=\"utf-8\">
						<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
						<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" 
							+ "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">					
					</head>
				""";
	}
	
	private String createDivTemplate(Content content) {
			String template = """
					<div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;\">
						<h4 class=\"card-header\">%s</h4>
						<div class=\"card-body\">
							<p class=\"card-text mt-2\">%s</p>
							<img class=\"card-img\" src=\"%s\" alt=\"%s\">
							<p class=\"card-text mt-2\">Nota: %s - Ano: %s</p>
						</div>
					</div>
			""";
		return String.format(template, 
					content.title(), 
					content.type(),
					content.urlImage(),
					content.title(), 
					content.rating(), 
					content.year());
	}
	
}
