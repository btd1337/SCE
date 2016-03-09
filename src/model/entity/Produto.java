package model.entity;

import model.DAO.ProdutoDAO;

public class Produto {

	private String nomeProduto;
	private String descricaoProduto;

	public Produto(String nomeProduto, String descricaoProduto) {
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public static void addProduto(Produto produto) {
		ProdutoDAO.addProduto(produto);		
	}


}