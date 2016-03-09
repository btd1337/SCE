package model.entity;

import model.DAO.FilialDAO;

public class Filial {

	private String nomeFilial;
	private String descricaoFilial;

	public Filial() {
	}

	public Filial(String nomeFilial, String descFilial) {
		this.nomeFilial = nomeFilial;
		this.descricaoFilial = descFilial;
	}

	public String getNomeFilial() {
		return nomeFilial;
	}

	public void setNomeFilial(String nomeFilial) {
		this.nomeFilial = nomeFilial;
	}

	public String getDescricaoFilial() {
		return descricaoFilial;
	}

	public void setDescricaoFilial(String descricaoFilial) {
		this.descricaoFilial = descricaoFilial;
	}

	public static void obterFiliais() {
		// TODO implement here
	}

	public static void selecionarFilial(String nomeFilial) {
		// TODO implement here
	}

	public static void addFilial(Filial filial) {
		FilialDAO.addFilial(filial);
	}

	public static void getDadosFilial(String nomeFilial) {
		// TODO implement here
	}

	public static void getFiliais(String nomeFilial) {
		// TODO implement here
	}

	public static void desativaFilial(Filial filialOrigem, Filial filialDestino) {
		// TODO implement here
	}

	public static String getDescricaoFilial(String nomeFilial) {
		return FilialDAO.getDescricaoFilial(nomeFilial);
	}

	public static void updateFilial(String elementoAlterado, Filial filial) {
		FilialDAO.updateFilial(elementoAlterado ,filial);
		
	}

	public static boolean isEstoqueVazio(String nomeFilial) {
		return FilialDAO.isEstoqueVazio(nomeFilial);
	}

	public static void desativaFilial(String nomeFilial) {
		FilialDAO.desativaFilial(nomeFilial);
		
	}

}