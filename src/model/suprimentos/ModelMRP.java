package model.suprimentos;

import java.sql.Date;

public class ModelMRP {
	private int IdSugestao_mrp_supri;
	private String tipoItem_mrp_supri;
	private int cod_alertrepo_supri; // puxar o cod_alertrepo_auto;
	private String categoria_mrp_supri;
	private String statusSugestao_mrp_supri;
	
	private int quantSugerida_mrp_supri;
	private int quantReservada_mrp_supri;
	private int quantSolicitada_mrp_supri;
	private Date dataPrevistaReposicao_mrp_supri;
	private int IdResponsavel;
	private String justificativa_mrp_supri;
	
	public ModelMRP() {}
	
	public ModelMRP(int IdSugestao)
}