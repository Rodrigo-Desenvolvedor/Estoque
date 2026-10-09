package model.inventario;

import java.sql.Date;

public class ModelAjustes {	
	private String item_inv_ajustes;
	private String descricao_inv_ajustes;
	private int quant_inv_ajustes;
	private double custos_inv_ajustes;
	private double custos_total_inv_ajustes;
	private int lote_inv_ajustes;
	private String status_inv_ajustes;
	private Date dt_val_inv_ajustes;
	
	public ModelAjustes() {}
	
	public ModelAjustes(String item_inv_ajustes, String descricaco_inv_ajustes,
						int quant_inv_ajustes, double custos_inv_ajustes,
						double custos_total_inv_ajustes, int lote_inv_ajustes,
						String status_inv_ajustes, Date dt_val_int_ajustes) {
		this();
		this.setItem_inv_ajustes(item_inv_ajustes);
		this.setDescricao_inv_ajustes(descricaco_inv_ajustes);
		this.setQuant_inv_ajustes(quant_inv_ajustes);
		this.setCustos_inv_ajustes(custos_inv_ajustes);
		this.setCustos_total_inv_ajustes(custos_total_inv_ajustes);
		this.setLote_inv_ajustes(lote_inv_ajustes);
		this.setStatus_inv_ajustes(status_inv_ajustes);
		this.setDt_val_inv_ajustes(dt_val_int_ajustes);
		}

	public String getItem_inv_ajustes() {
		return item_inv_ajustes;
	}

	public void setItem_inv_ajustes(String item_inv_ajustes) {
		this.item_inv_ajustes = item_inv_ajustes;
	}

	public String getDescricao_inv_ajustes() {
		return descricao_inv_ajustes;
	}

	public void setDescricao_inv_ajustes(String descricao_inv_ajustes) {
		this.descricao_inv_ajustes = descricao_inv_ajustes;
	}

	public int getQuant_inv_ajustes() {
		return quant_inv_ajustes;
	}

	public void setQuant_inv_ajustes(int quant_inv_ajustes) {
		this.quant_inv_ajustes = quant_inv_ajustes;
	}

	public double getCustos_inv_ajustes() {
		return custos_inv_ajustes;
	}

	public void setCustos_inv_ajustes(double custos_inv_ajustes) {
		this.custos_inv_ajustes = custos_inv_ajustes;
	}

	public double getCustos_total_inv_ajustes() {
		return custos_total_inv_ajustes;
	}

	public void setCustos_total_inv_ajustes(double custos_total_inv_ajustes) {
		this.custos_total_inv_ajustes = custos_total_inv_ajustes;
	}

	public int getLote_inv_ajustes() {
		return lote_inv_ajustes;
	}

	public void setLote_inv_ajustes(int lote_inv_ajustes) {
		this.lote_inv_ajustes = lote_inv_ajustes;
	}

	public String getStatus_inv_ajustes() {
		return status_inv_ajustes;
	}

	public void setStatus_inv_ajustes(String status_inv_ajustes) {
		this.status_inv_ajustes = status_inv_ajustes;
	}

	public Date getDt_val_inv_ajustes() {
		return dt_val_inv_ajustes;
	}

	public void setDt_val_inv_ajustes(Date dt_val_inv_ajustes) {
		this.dt_val_inv_ajustes = dt_val_inv_ajustes;
	}
	}