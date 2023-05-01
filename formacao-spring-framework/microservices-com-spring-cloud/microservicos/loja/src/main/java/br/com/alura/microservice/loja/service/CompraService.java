package br.com.alura.microservice.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.dto.CompraDTO;
import br.com.alura.microservice.loja.dto.InfoFornecedorDTO;
import br.com.alura.microservice.loja.dto.InfoPedidoDTO;
import br.com.alura.microservice.loja.model.Compra;

@Service
public class CompraService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);
	
	@Autowired
	private FornecedorClient client;

	public Compra realizaCompra(CompraDTO dto) {
		
		final String estado = dto.getEndereco().getEstado();
		
		LOG.info("bucando informações do fornecedor de {}", estado);
		InfoFornecedorDTO info = client.getInfoPorEstado(dto.getEndereco().getEstado());
		
		LOG.info("realizando um pedido");
		InfoPedidoDTO pedido = client.realizaPedido(dto.getItens());
		
		Compra compra = new Compra();
		compra.setPedidoId(pedido.getId());
		compra.setTempoDePreparo(pedido.getTempoDePreparo());
		compra.setEnderecoDestino(dto.getEndereco().toString());
		
		return compra;
	}
}
