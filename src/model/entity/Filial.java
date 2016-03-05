package model.entity;

public class Filial {

	private int idFilial;
	private String nomeFilial;
	private String descricaoFilial;

	public Filial() {
	}

	public int getIdFilial() {
		return idFilial;
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

	public void obterFiliais() {
		// TODO implement here
	}

	public void selecionarFilial(String nomeFilial) {
		// TODO implement here
	}

	public void addFilial(Filial filial) {
		// TODO implement here
	}

	public void getDadosFilial(String nomeFilial) {
		// TODO implement here
	}

	public void updateFilial(int idFilial, String nomeFilial, String descFilial) {
		// TODO implement here
	}

	public void getFiliais(String nomeFilial) {
		// TODO implement here
	}

	public void desativaFilial(Filial filialOrigem, Filial filialDestino) {
		// TODO implement here
	}

}