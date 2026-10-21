package model.suprimentos;

public class ModelFornecedorItem {
	private int idFornecedor;
	private String tipoItem;
	private String codigoItem;
	private int leadTime;
	
	public ModelFornecedorItem() {}
	
	public ModelFornecedorItem(int idFornecedor, String tipoItem,
								 String codigoItem, int leadTime) {
		this();
		this.setIdFornecedor(idFornecedor);
		this.setTipoItem(tipoItem);
		this.setCodigoItem(codigoItem);
		this.setLeadTime(leadTime);
	}

	public int getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
	}

	public String getCodigoItem() {
		return codigoItem;
	}

	public void setCodigoItem(String codigoItem) {
		this.codigoItem = codigoItem;
	}

	public int getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(int leadTime) {
		this.leadTime = leadTime;
	}
}
