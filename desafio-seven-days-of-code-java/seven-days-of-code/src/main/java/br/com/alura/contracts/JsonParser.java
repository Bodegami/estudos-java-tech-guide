package br.com.alura.contracts;

import java.util.List;

public interface JsonParser {
	public List<? extends Content> parse();
}
