package br.com.depot.controller;

import java.util.Collection;
import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.depot.dao.ProdutoDAO;
import br.com.depot.model.Produto;

@Resource
public class ProdutosController {

    private ProdutoDAO produtoDAO;
    private Result result;
	
	public ProdutosController(ProdutoDAO produtoDAO, Result result) {
		this.produtoDAO = produtoDAO;
        this.result = result;
	}	
	
	@Get("/produtos")
	public Collection<Produto> lista() {
		Collection<Produto> result = produtoDAO.retornaTodos();
		System.out.println("lista:");
		for(Produto produto: result) System.out.println("  " + produto.toString());
		return result;
	}
	
	@Get("/produtos/novo")
	public Produto novo() {
		Produto produto = new Produto();
		System.out.println("novo: " + produto.toString());
		return produto;
	}	
	
	@Get("/produtos/{produto.id}")
	public Produto visualiza(Produto produto) {
		produto = produtoDAO.retornaComId(produto.getId());
		System.out.println("visualiza: " + produto.toString());
		return produto;
	}	
	
	@Put("/produtos")
	public void salva(Produto produto) {
		System.out.println("salva: " + produto.toString());
		produtoDAO.salva(produto);
		result.redirectTo(ProdutosController.class).visualiza(produto);
	}	
	
	@Post("/produtos")
	public void adiciona(Produto produto) {
		System.out.println(produto.toString());
		produtoDAO.cria(produto);
		result.redirectTo(ProdutosController.class).visualiza(produto);
	} 
	
	@Delete("/produtos")
	public void apaga(Produto produto) {
		System.out.println("apaga: " + produto.toString());
		produtoDAO.exclui(produto);
		result.redirectTo(ProdutosController.class).lista(); 
	} 
}
