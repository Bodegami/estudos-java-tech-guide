package br.com.alura.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.dto.CompraDTO;
import br.com.alura.microservice.loja.dto.InfoFornecedorDTO;
import br.com.alura.microservice.loja.dto.InfoPedidoDTO;
import br.com.alura.microservice.loja.model.Compra;

@Service
public class CompraService {
	
	@Autowired
	private FornecedorClient client;

	public Compra realizaCompra(CompraDTO dto) {
		
		InfoFornecedorDTO info = client.getInfoPorEstado(dto.getEndereco().getEstado());
		
		InfoPedidoDTO pedido = client.realizaPedido(dto.getItens());
		
		System.out.println(info.getEndereco());
		
		Compra compra = new Compra();
		compra.setPedidoId(pedido.getId());
		compra.setTempoDePreparo(pedido.getTempoDePreparo());
		compra.setEnderecoDestino(dto.getEndereco().toString());
		
		System.out.println(compra);
		
		return compra;
	}
}
