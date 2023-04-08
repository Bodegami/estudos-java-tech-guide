package br.com.alura.loja;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class ProdutoTest {

	@Test
	public void test() {
		Produto p = new Produto("test", BigDecimal.TEN);
		Assert.assertEquals("test", p.getNome());
		Assert.assertEquals(BigDecimal.TEN, p.getPreco());
	}

}
