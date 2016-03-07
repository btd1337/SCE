package controller;

import model.entity.Filial;

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

	public static void getDadosFilial(String nomeFilial) {
		// TODO implement here
	}

	public static void updateFilial(String nomeFilial, String descFilial) {
		Filial filial = new Filial(nomeFilial,descFilial);
		//TODO metodo update
	}

	public static void desativarFilial(Filial filialOrigem, Filial filialDestino) {
		// TODO implement here
	}

	public static void getFiliais(String nomeFilial) {
		// TODO implement here
	}

	public static void addProduto(String nome, String descricao) {
		// TODO Auto-generated method stub
		
	}

}