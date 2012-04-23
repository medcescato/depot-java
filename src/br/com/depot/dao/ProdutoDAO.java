package br.com.depot.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

import br.com.caelum.vraptor.ioc.Component;
import br.com.depot.model.Produto;

@Component
public class ProdutoDAO {

	// inicio - remover este codigo qdo usar BD
	private static long idAtual = 0;
	
	private static Map<Long, Produto> produtos = new HashMap<Long, Produto>();

	static {
		Produto produtosArray[] = new Produto[] {
			cria().comTitulo("Java Avancado").comDescricao("Livro muito bom para quem quer aprender Java com mais profundidade"),
			cria().comTitulo("Mastering TDD").comDescricao("Ensina tecnicas de programacao de testes.")
		};
		for (Produto produto: produtosArray) produtos.put(produto.getId(), produto);
	}
	
	private static Produto cria() {
		Produto produto = new Produto();
		criaNovo(produto);
		return produto; 
	}
	
	private static boolean criaNovo(Produto produto) {
		produto = produto.comId(new Long(++idAtual));
		produtos.put(produto.getId(), produto);
		return true;
	}
			
	// fim - remover este codigo qdo usar BD
	
	public Collection<Produto> retornaTodos() {
		return produtos.values();
	}

	public Produto retornaComId(Long id) {
		return produtos.get(id);
	}
	
	public boolean cria(Produto produto) {
		return ProdutoDAO.criaNovo(produto);
	}	
	
	public boolean salva(Produto produto) {
		produtos.put(produto.getId(), produto);
		return true;
	}
	
	public boolean exclui(Produto produto) {
		boolean result = false;
		Long id = produto.getId();
		if (produtos.containsKey(id)) {
			produtos.remove(id);
			result = true;
		}
		return result;
	}
	
	
}
