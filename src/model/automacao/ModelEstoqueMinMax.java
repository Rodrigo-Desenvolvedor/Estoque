package model.automacao;

public class ModelEstoqueMinMax {
	private String codprod_sku_minmax_auto;
	private String status_minmax_auto;
	private int estoque_min_minmax_auto;
	private int estoque_max_minmax_auto;
	
	public ModelEstoqueMinMax() {}
	
	public ModelEstoqueMinMax(String codprod_sku_minmax_auto,
							  String status_minmax_auto,
							  int estoque_min_minmax_auto,
							  int estoque_max_minmax_auto) {
		this();
		this.setCodprod_sku_minmax_auto(codprod_sku_minmax_auto);
		this.setStatus_minmax_auto(status_minmax_auto);
		this.setEstoque_min_minmax_auto(estoque_min_minmax_auto);
		this.setEstoque_max_minmax_auto(estoque_max_minmax_auto);
	}

	public String getCodprod_sku_minmax_auto() {
		return codprod_sku_minmax_auto;
	}

	public void setCodprod_sku_minmax_auto(String codprod_sku_minmax_auto) {
		this.codprod_sku_minmax_auto = codprod_sku_minmax_auto;
	}

	public String getStatus_minmax_auto() {
		return status_minmax_auto;
	}

	public void setStatus_minmax_auto(String status_minmax_auto) {
		this.status_minmax_auto = status_minmax_auto;
	}

	public int getEstoque_min_minmax_auto() {
		return estoque_min_minmax_auto;
	}

	public void setEstoque_min_minmax_auto(int estoque_min_minmax_auto) {
		this.estoque_min_minmax_auto = estoque_min_minmax_auto;
	}

	public int getEstoque_max_minmax_auto() {
		return estoque_max_minmax_auto;
	}

	public void setEstoque_max_minmax_auto(int estoque_max_minmax_auto) {
		this.estoque_max_minmax_auto = estoque_max_minmax_auto;
	}
}