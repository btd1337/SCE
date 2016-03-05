package model.entity;

public class Produto {

	private int idProduto;
	private String nomeProduto;
	private String descricaoProduto;

	public Produto() {
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

	public int getIdProduto() {
		return idProduto;
	}

}