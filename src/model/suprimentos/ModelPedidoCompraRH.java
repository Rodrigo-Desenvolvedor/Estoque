package model.suprimentos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ModelPedidoCompraRH {

	private int idPedidoRH;
	private int idRequisicaoRH;
	private int idFornecedor;
	private String tipoBeneficio;
	private String competenciaReferencia;
	private BigDecimal valorTotalConsolidado;
	private BigDecimal valorResponsabilidadeEmpresa;
	private int idProcessamentoRH;
	private String documentoAquisicao;
	private LocalDate dataPedido;
	private String statusPedido;
	private String observacao;

	public ModelPedidoCompraRH() {}

	public ModelPedidoCompraRH(int idPedidoRH, int idRequisicaoRH,
							   int idFornecedor, String tipoBeneficio,
							   String competenciaReferencia,
							   BigDecimal valorTotalConsolidado,
							   BigDecimal valorResponsabilidadeEmpresa,
							   int idProcessamentoRH,
							   String documentoAquisicao,
							   LocalDate dataPedido, String statusPedido,
							   String observacao) {
		this();
		this.setIdPedidoRH(idPedidoRH);
		this.setIdRequisicaoRH(idRequisicaoRH);
		this.setIdFornecedor(idFornecedor);
		this.setTipoBeneficio(tipoBeneficio);
		this.setCompetenciaReferencia(competenciaReferencia);
		this.setValorTotalConsolidado(valorTotalConsolidado);
		this.setValorResponsabilidadeEmpresa(valorResponsabilidadeEmpresa);
		this.setIdProcessamentoRH(idProcessamentoRH);
		this.setDocumentoAquisicao(documentoAquisicao);
		this.setDataPedido(dataPedido);
		this.setStatusPedido(statusPedido);
		this.setObservacao(observacao);
	}

	public int getIdPedidoRH() {
		return idPedidoRH;
	}

	public void setIdPedidoRH(int idPedidoRH) {
		this.idPedidoRH = idPedidoRH;
	}

	public int getIdRequisicaoRH() {
		return idRequisicaoRH;
	}

	public void setIdRequisicaoRH(int idRequisicaoRH) {
		this.idRequisicaoRH = idRequisicaoRH;
	}

	public int getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getTipoBeneficio() {
		return tipoBeneficio;
	}

	public void setTipoBeneficio(String tipoBeneficio) {
		this.tipoBeneficio = tipoBeneficio;
	}

	public String getCompetenciaReferencia() {
		return competenciaReferencia;
	}

	public void setCompetenciaReferencia(String competenciaReferencia) {
		this.competenciaReferencia = competenciaReferencia;
	}

	public BigDecimal getValorTotalConsolidado() {
		return valorTotalConsolidado;
	}

	public void setValorTotalConsolidado(BigDecimal valorTotalConsolidado) {
		this.valorTotalConsolidado = valorTotalConsolidado;
	}

	public BigDecimal getValorResponsabilidadeEmpresa() {
		return valorResponsabilidadeEmpresa;
	}

	public void setValorResponsabilidadeEmpresa(BigDecimal valorResponsabilidadeEmpresa) {
		this.valorResponsabilidadeEmpresa = valorResponsabilidadeEmpresa;
	}

	public int getIdProcessamentoRH() {
		return idProcessamentoRH;
	}

	public void setIdProcessamentoRH(int idProcessamentoRH) {
		this.idProcessamentoRH = idProcessamentoRH;
	}

	public String getDocumentoAquisicao() {
		return documentoAquisicao;
	}

	public void setDocumentoAquisicao(String documentoAquisicao) {
		this.documentoAquisicao = documentoAquisicao;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}

	public String getObservacao() {
    		return observacao;
	}

	public void setObservacao(String observacao) {
    		this.observacao = observacao;
	}
}