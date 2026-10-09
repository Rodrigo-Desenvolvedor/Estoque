package model.automacao;

public class ModelAlertaReposicao {
	private int cod_alertrepo_auto; // Identificador - gerado ao clicar no botão "Gerar ordem de compra" 
	private String codprod_sku_alertrepo_auto;
	private String nivel_urgencia_alertrepo_auto;
	
	public ModelAlertaReposicao() {}
	
	public ModelAlertaReposicao(int cod_alerrepo_auto,
								String codprod_sku_alertrepo_auto,
								String nivel_urgencia_alertrepo_auto) {
		this();
		this.setCod_alertrepo_auto(cod_alerrepo_auto);
		this.setCodprod_sku_alertrepo_auto(codprod_sku_alertrepo_auto);
		this.setNivel_urgencia_alertrepo_auto(nivel_urgencia_alertrepo_auto);
	}

	public int getCod_alertrepo_auto() {
		return cod_alertrepo_auto;
	}

	public void setCod_alertrepo_auto(int cod_alertrepo_auto) {
		this.cod_alertrepo_auto = cod_alertrepo_auto;
	}

	public String getCodprod_sku_alertrepo_auto() {
		return codprod_sku_alertrepo_auto;
	}

	public void setCodprod_sku_alertrepo_auto(String codprod_sku_alertrepo_auto) {
		this.codprod_sku_alertrepo_auto = codprod_sku_alertrepo_auto;
	}

	public String getNivel_urgencia_alertrepo_auto() {
		return nivel_urgencia_alertrepo_auto;
	}

	public void setNivel_urgencia_alertrepo_auto(String nivel_urgencia_alertrepo_auto) {
		this.nivel_urgencia_alertrepo_auto = nivel_urgencia_alertrepo_auto;
	}
}