package controller;

import model.entity.Filial;
import model.entity.Produto;

public class GerenciaFilialController {

	public GerenciaFilialController() {
	}

	public static void getFiliais() {
		// TODO implement here
	}

	public static void selectFilial(String nomeFilial) {
		// TODO implement here
	}

	public static void addFilial(String nomeFilial, String descFilial) {
		Filial filial = new Filial(nomeFilial,descFilial);
		Filial.addFilial(filial);
	}

	public static String getDescricaoFilial(String nomeFilial) {
		return Filial.getDescricaoFilial(nomeFilial);
	}

	public static void updateFilial(String elementoAlterado,String newNomeFilial, String newDescFilial) {
		Filial filial = new Filial(newNomeFilial,newDescFilial);
		Filial.updateFilial(elementoAlterado, filial);
	}

	public static void desativarFilial(Filial filialOrigem, Filial filialDestino) {
		// TODO implement here
	}

	public static void getFiliais(String nomeFilial) {
		// TODO implement here
	}

	public static void addProduto(String nome, String descricao) {
		Produto produto = new Produto(nome, descricao);
		Produto.addProduto(produto);
		
	}

	public static boolean isEstoqueVazio(String nomeFilial) {
		return Filial.isEstoqueVazio(nomeFilial);
	}

	public static void desativarFilial(String nomeFilial) {
		Filial.desativaFilial(nomeFilial);		
	}

}