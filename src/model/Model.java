package model;

import java.util.*;

public class Model {
	// cadastro produto
	private String codigo_prod; // Identificador FK
	private String nome_prod; 
	private String categoria_prod;
	private String descricao_prod;
	private String uni_med_prod;
	private String quant_prod;
	private String peso_prod;
	private String preco_prod; 
	private int estoque_prod_min;
	private int estoque_prod_max;
	private String status_prod;
	
	// cadastro variações
	private String nome_prod_var;	
	private String sku;  // Identificador
	private String nome_var;
	private String tamanho_prod_var;
	private String cor_prod_var;
	private String modelo_prod_var; // puxando de modelo_prod de Cadasto Produto
	private int quantidade_prod;
	private String preco_prod_var;
	
	// cadastro kit
	private String codigo_kit; // Identificador
	private String nome_kit;
	private String tipo_kit;
	private int quantidade_kit;
	private String cod_prod_sku_kit; // fazer uma comparação deste com algum cod_prod ou sku existente
	private String nome_prod_kit; // puxar uma aba com os nomes de produtos possiveis
	private int quant_prod_kit; // quantidade de produtos no kit
	
	
	// movimentação entrada e saida
	private String tipo_mov_es;
	//um private a mais, ou só um metodo de chamada de FK	// precisa puxar os nomes dos produtos de nome_prod, para saber que produto esta sendo movimentado
	//um private a mais, ou só um metodo de chamada de FK	// precisa puxar o código do produto de codigo_prod, para saber exatamente qual produto esta sendo movimentado
	private int quantidade_mov_es;
	private String motivo_mov_es;
	private String doc_mov_es;
	private String origem_mov_es; 
	private String destino_mov_es;
	private String responsavel_mov_es;
	private String obs_mov_es;
	
	// movimentação lote e serie
	//um private a mais, ou só um metodo de chamada de FK	// precisa puxar os nomes dos produtos de nome_prod, para saber qual o produto
	private int lote_mov_lote;
	private Date dt_fab_mov_lote;
	private String fornecedor_mov_lote;
	private String tipo_mov_lote;
	private int numero_serie_mov_lote; // Identificador FK
	private Date dt_val_mov_lote;
	
	// movimentação multilocalização
	private String nome_prod_mov_mult;  // precisa puxar os nomes dos produtos de nome_prod, para saber as localizações de qual produto estamos localizando
	
	private String origem_mov_mult;
	private String prod_mov_mult; // precisa puxar os nomes dos produtos de nome_prod, para saber qual produto esta sendo mudando de local
	private int lote_mov_mult; // puxando de Lote e Serie, o cod_mov_lote
	private String doc_mov_mult;
	private String destino_mov_mult;
	private int quantidade_mov_mult;
	private int numero_serie_mov_mult; // puxando de Lote e Serie, o numero_serie_mov_lote
	private String obs_mov_mult;
	
	// inventario ajustes
	private String item_inv_ajustes;
	private String descricao_inv_ajustes;
	private int quantidade_inv_ajustes;
	private String preco_inv_ajustes;
	private String preco_total_inv_ajustes;
	//um private a mais, ou só um metodo de chamada de FK	// precisa puxar os numeros de lotes de lote_mov_lote, para saber de qual lote estamos mudando as coisas
	private String status_inv_ajustes;
	private Date dt_val_inv_ajustes;
	
	// inventario inventario
	private String nome_inv;
	private String descricao_inv;
	private String quantidade_estoque_inv; 
	private String quantidade_inv; 
	

	//			AVISO, POR VIA DAS DÚVIDAS NÃO COLOQUEM NADA RELACIONADO A PARTE DE AUTOMAÇÃO no BANCO DE DADOS, PARECE INCOMPLETO, CASO ESTEJA COMPLETO EU APAGAREI ESTA MENSAGEM
	//          AVISO, POR VIA DAS DÚVIDAS NÃO COLOQUEM NADA RELACIONADO A PARTE DE AUTOMAÇÃO no BANCO DE DADOS, PARECE INCOMPLETO, CASO ESTEJA COMPLETO EU APAGAREI ESTA MENSAGEM
	//          AVISO, POR VIA DAS DÚVIDAS NÃO COLOQUEM NADA RELACIONADO A PARTE DE AUTOMAÇÃO no BANCO DE DADOS, PARECE INCOMPLETO, CASO ESTEJA COMPLETO EU APAGAREI ESTA MENSAGEM
	
	// automacao alerta reposição  ----- não creio que seja necessario, mas se estou errado me avisem
	
	// automação estoque min/mas    ----- fiquei confuso em que colocar, acho que falta coisa ai
	private String nome_prod_auto_minmax; // precisa puxar os nomes dos produtos de nome_prod, para saber qual produto estamos verificando o estoque
	private int estoque_min_auto_minmax;
	private int estoque_max_auto_minmax;

	// automação giro estoque  ---- fiquei confuso, mas vou colocar o que eu acho que deveria ter
	private String nome_auto_giro;
	private String class_auto_giro;
	// olha não entendi direito como funciona, mas a ideia que eu tive é que já que calcula o giro, então poderia verificar
	// a partir de dois inputs, snedo o nome e a classificação, olhar e ver quais são compativeis com a verificação, que
	// depois vai calcular o quanto foi o giro daquilo, pode ser produto, variação ou kit(a verificação deve comparar com os 3)
	//
	// e caso queiram mais um modo de classificar, então poderiamos trocar ou adicionar este de baixo aqui
	private String tipo_auto_giro; // seria basicamente para definir qual tipo seria entre: produto, variação ou kit.
	
	//          AVISO, POR VIA DAS DÚVIDAS NÃO COLOQUEM NADA RELACIONADO A PARTE DE AUTOMAÇÃO no BANCO DE DADOS, PARECE INCOMPLETO, CASO ESTEJA COMPLETO EU APAGAREI ESTA MENSAGEM
	//          AVISO, POR VIA DAS DÚVIDAS NÃO COLOQUEM NADA RELACIONADO A PARTE DE AUTOMAÇÃO no BANCO DE DADOS, PARECE INCOMPLETO, CASO ESTEJA COMPLETO EU APAGAREI ESTA MENSAGEM
	//          AVISO, POR VIA DAS DÚVIDAS NÃO COLOQUEM NADA RELACIONADO A PARTE DE AUTOMAÇÃO no BANCO DE DADOS, PARECE INCOMPLETO, CASO ESTEJA COMPLETO EU APAGAREI ESTA MENSAGEM
	
	
	// relatorio MRP
	private String nome_prod_relatorio_mrp; // precisa puxar os nomes dos produtos de nome_prod, para saber qual produto será analisado
	private String categoria_relatorio_mrp; 
	private String status_relatorio_mrp;
	
	private String sugestao_relatorio_mrp;
	private Date data_prev_repo_relatorio_mrp;
	private String responsavel_relatorio_mrp;
	private String justificativa_relatorio_mrp;
	
	public Model() {}
	
	public Model(
			String codigo_prod,
			String nome_prod,
			String categoria_prod,
			String descricao_prod,
			String uni_med_prod,
			String quant_prod,
			String peso_prod,
			String preco_prod,
			int estoque_prod_min,
			int estoque_prod_max,
			String status_prod,
			
			String nome_prod_var,
			String sku,
			String nome_var,
			String tamanho_prod_var,
			String cor_prod_var,
			String modelo_prod_var,
			int quantidade_prod,
			String preco_prod_var,
			
			String codigo_kit,
			String nome_kit,
			String tipo_kit,
			int quantidade_kit,
			String cod_prod_sku_kit,
			String nome_prod_kit,
			int quant_prod_kit,
			
			String tipo_mov_es,
			int quantidade_mov_es,
			String motivo_mov_es,
			String doc_mov_es,
			String origem_mov_es,
			String destino_mov_es,
			String responsavel_mov_es,
			String obs_mov_es,
			
			int lote_mov_lote,
			Date dt_fab_mov_lote,
			String fornecedor_mov_lote,
			String tipo_mov_lote,
			int numero_serie_mov_lote,
			Date dt_val_mov_lote,
			
			String nome_prod_mov_mult,
			String origem_mov_mult,
			String prod_mov_mult,
			int lote_mov_mult,
			String doc_mov_mult,
			String destino_mov_mult,
			int quantidade_mov_mult,
			int numero_serie_mov_mult,
			String obs_mov_mult,
			
			String item_inv_ajustes,
			String descricao_inv_ajustes,
			int quantidade_inv_ajustes,
			String preco_inv_ajustes,
			String preco_total_inv_ajustes,
			String status_inv_ajustes,
			Date dt_val_inv_ajustes,
			
			String nome_inv,
			String descricao_inv,
			String quantidade_estoque_inv,
			String quantidade_inv,
			
			String nome_prod_auto_minmax,
			int estoque_min_auto_minmax,
			int estoque_max_auto_minmax,
			
			String nome_auto_giro,
			String class_auto_giro,
			String tipo_auto_giro,
			
			String nome_prod_relatorio_mrp,
			String categoria_relatorio_mrp,
			String status_relatorio_mrp,
			String sugestao_relatorio_mrp,
			Date data_prev_repo_relatorio_mrp,
			String responsavel_relatorio_mrp,
			String justificativa_relatorio_mrp
				) {
		this();
		this.setCodigo_prod(codigo_prod);
		this.setNome_prod(nome_prod);
		this.setCategoria_prod(categoria_prod);
		this.setDescricao_prod(descricao_prod);
		this.setUni_med_prod(uni_med_prod);
		this.setQuant_prod(quant_prod);
		this.setPeso_prod(peso_prod);
		this.setPreco_prod(preco_prod);
		this.setEstoque_prod_max(estoque_prod_max);
		this.setEstoque_prod_min(estoque_prod_min);
		this.setStatus_prod(status_prod);
		
		this.setNome_prod_var(nome_prod_var);
		this.setSku(sku);
		this.setNome_var(nome_var);
		this.setTamanho_prod_var(tamanho_prod_var);
		this.setCor_prod_var(cor_prod_var);
		this.setModelo_prod_var(modelo_prod_var);
		this.setQuantidade_prod(quantidade_prod);
		this.setNome_prod_kit(nome_prod_kit);
		this.setPreco_prod_var(preco_prod_var);
		
		this.setCodigo_kit(codigo_kit);
		this.setNome_kit(nome_kit);
		this.setTipo_kit(tipo_kit);
		this.setQuantidade_kit(quantidade_kit);
		this.setCod_prod_sku_kit(cod_prod_sku_kit);
		this.setNome_prod_kit(nome_prod_kit);
		this.setQuant_prod_kit(quant_prod_kit);
		
		this.setTipo_mov_es(tipo_mov_es);
		this.setQuantidade_mov_es(quantidade_mov_es);
		this.setMotivo_mov_es(motivo_mov_es);
		this.setDoc_mov_es(doc_mov_es);
		this.setOrigem_mov_es(origem_mov_es);
		this.setDestino_mov_es(destino_mov_es);
		this.setResponsavel_mov_es(responsavel_mov_es);
		this.setObs_mov_es(obs_mov_es);
		
		this.setLote_mov_lote(lote_mov_lote);
		this.setDt_fab_mov_lote(dt_fab_mov_lote);
		this.setFornecedor_mov_lote(fornecedor_mov_lote);
		this.setTipo_mov_lote(tipo_mov_lote);
		this.setNumero_serie_mov_lote(numero_serie_mov_lote);
		this.setDt_val_mov_lote(dt_val_mov_lote);
		
		this.setNome_prod_mov_mult(nome_prod_mov_mult);
		this.setOrigem_mov_mult(origem_mov_mult);
		this.setProd_mov_mult(prod_mov_mult);
		this.setLote_mov_mult(lote_mov_mult);
		this.setDoc_mov_mult(doc_mov_mult);
		this.setDestino_mov_mult(destino_mov_mult);
		this.setQuantidade_mov_mult(quantidade_mov_mult);
		this.setNumero_serie_mov_mult(numero_serie_mov_mult);
		this.setObs_mov_mult(obs_mov_mult);
		
		this.setItem_inv_ajustes(item_inv_ajustes);
		this.setDescricao_inv_ajustes(descricao_inv_ajustes);
		this.setQuantidade_inv_ajustes(quantidade_inv_ajustes);
		this.setPreco_inv_ajustes(preco_inv_ajustes);
		this.setPreco_total_inv_ajustes(preco_total_inv_ajustes);
		this.setStatus_inv_ajustes(status_inv_ajustes);
		this.setDt_val_inv_ajustes(dt_val_inv_ajustes);
		
		this.setNome_inv(nome_inv);
		this.setDescricao_inv(descricao_inv);
		this.setQuantidade_estoque_inv(quantidade_estoque_inv);
		this.setQuantidade_inv(quantidade_inv);
		
		this.setNome_prod_auto_minmax(nome_prod_auto_minmax);
		this.setEstoque_min_auto_minmax(estoque_min_auto_minmax);
		this.setEstoque_max_auto_minmax(estoque_max_auto_minmax);
		
		this.setNome_auto_giro(nome_auto_giro);
		this.setClass_auto_giro(class_auto_giro);
		this.setTipo_auto_giro(tipo_auto_giro);
		
		this.setNome_prod_relatorio_mrp(nome_prod_relatorio_mrp);
		this.setCategoria_relatorio_mrp(categoria_relatorio_mrp);
		this.setStatus_relatorio_mrp(status_relatorio_mrp);
		this.setSugestao_relatorio_mrp(sugestao_relatorio_mrp);
		this.setData_prev_repo_relatorio_mrp(data_prev_repo_relatorio_mrp);
		this.setResponsavel_relatorio_mrp(responsavel_relatorio_mrp);
		this.setJustificativa_relatorio_mrp(justificativa_relatorio_mrp);
	}

	public String getCodigo_prod() {
		return codigo_prod;
	}

	public void setCodigo_prod(String codigo_prod) {
		this.codigo_prod = codigo_prod;
	}

	public String getNome_prod() {
		return nome_prod;
	}

	public void setNome_prod(String nome_prod) {
		this.nome_prod = nome_prod;
	}

	public String getCategoria_prod() {
		return categoria_prod;
	}

	public void setCategoria_prod(String categoria_prod) {
		this.categoria_prod = categoria_prod;
	}

	public String getDescricao_prod() {
		return descricao_prod;
	}

	public void setDescricao_prod(String descricao_prod) {
		this.descricao_prod = descricao_prod;
	}

	public String getUni_med_prod() {
		return uni_med_prod;
	}

	public void setUni_med_prod(String uni_med_prod) {
		this.uni_med_prod = uni_med_prod;
	}

	public String getQuant_prod() {
		return quant_prod;
	}

	public void setQuant_prod(String quant_prod) {
		this.quant_prod = quant_prod;
	}

	public String getPeso_prod() {
		return peso_prod;
	}

	public void setPeso_prod(String peso_prod) {
		this.peso_prod = peso_prod;
	}

	public String getPreco_prod() {
		return preco_prod;
	}

	public void setPreco_prod(String preco_prod) {
		this.preco_prod = preco_prod;
	}

	public int getEstoque_prod_min() {
		return estoque_prod_min;
	}

	public void setEstoque_prod_min(int estoque_prod_min) {
		this.estoque_prod_min = estoque_prod_min;
	}

	public int getEstoque_prod_max() {
		return estoque_prod_max;
	}

	public void setEstoque_prod_max(int estoque_prod_max) {
		this.estoque_prod_max = estoque_prod_max;
	}

	public String getStatus_prod() {
		return status_prod;
	}

	public void setStatus_prod(String status_prod) {
		this.status_prod = status_prod;
	}

	public String getNome_prod_var() {
		return nome_prod_var;
	}

	public void setNome_prod_var(String nome_prod_var) {
		this.nome_prod_var = nome_prod_var;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome_var() {
		return nome_var;
	}

	public void setNome_var(String nome_var) {
		this.nome_var = nome_var;
	}

	public String getTamanho_prod_var() {
		return tamanho_prod_var;
	}

	public void setTamanho_prod_var(String tamanho_prod_var) {
		this.tamanho_prod_var = tamanho_prod_var;
	}

	public String getCor_prod_var() {
		return cor_prod_var;
	}

	public void setCor_prod_var(String cor_prod_var) {
		this.cor_prod_var = cor_prod_var;
	}

	public String getModelo_prod_var() {
		return modelo_prod_var;
	}

	public void setModelo_prod_var(String modelo_prod_var) {
		this.modelo_prod_var = modelo_prod_var;
	}

	public int getQuantidade_prod() {
		return quantidade_prod;
	}

	public void setQuantidade_prod(int quantidade_prod) {
		this.quantidade_prod = quantidade_prod;
	}

	public String getPreco_prod_var() {
		return preco_prod_var;
	}

	public void setPreco_prod_var(String preco_prod_var) {
		this.preco_prod_var = preco_prod_var;
	}

	public String getCodigo_kit() {
		return codigo_kit;
	}

	public void setCodigo_kit(String codigo_kit) {
		this.codigo_kit = codigo_kit;
	}

	public String getNome_kit() {
		return nome_kit;
	}

	public void setNome_kit(String nome_kit) {
		this.nome_kit = nome_kit;
	}

	public String getTipo_kit() {
		return tipo_kit;
	}

	public void setTipo_kit(String tipo_kit) {
		this.tipo_kit = tipo_kit;
	}

	public int getQuantidade_kit() {
		return quantidade_kit;
	}

	public void setQuantidade_kit(int quantidade_kit) {
		this.quantidade_kit = quantidade_kit;
	}

	public String getCod_prod_sku_kit() {
		return cod_prod_sku_kit;
	}

	public void setCod_prod_sku_kit(String cod_prod_sku_kit) {
		this.cod_prod_sku_kit = cod_prod_sku_kit;
	}

	public String getNome_prod_kit() {
		return nome_prod_kit;
	}

	public void setNome_prod_kit(String nome_prod_kit) {
		this.nome_prod_kit = nome_prod_kit;
	}

	public int getQuant_prod_kit() {
		return quant_prod_kit;
	}

	public void setQuant_prod_kit(int quant_prod_kit) {
		this.quant_prod_kit = quant_prod_kit;
	}

	public int getQuantidade_mov_es() {
		return quantidade_mov_es;
	}

	public void setQuantidade_mov_es(int quantidade_mov_es) {
		this.quantidade_mov_es = quantidade_mov_es;
	}

	public String getTipo_mov_es() {
		return tipo_mov_es;
	}

	public void setTipo_mov_es(String tipo_mov_es) {
		this.tipo_mov_es = tipo_mov_es;
	}

	public String getMotivo_mov_es() {
		return motivo_mov_es;
	}

	public void setMotivo_mov_es(String motivo_mov_es) {
		this.motivo_mov_es = motivo_mov_es;
	}

	public String getDoc_mov_es() {
		return doc_mov_es;
	}

	public void setDoc_mov_es(String doc_mov_es) {
		this.doc_mov_es = doc_mov_es;
	}

	public String getOrigem_mov_es() {
		return origem_mov_es;
	}

	public void setOrigem_mov_es(String origem_mov_es) {
		this.origem_mov_es = origem_mov_es;
	}

	public String getDestino_mov_es() {
		return destino_mov_es;
	}

	public void setDestino_mov_es(String destino_mov_es) {
		this.destino_mov_es = destino_mov_es;
	}

	public String getResponsavel_mov_es() {
		return responsavel_mov_es;
	}

	public void setResponsavel_mov_es(String responsavel_mov_es) {
		this.responsavel_mov_es = responsavel_mov_es;
	}

	public String getObs_mov_es() {
		return obs_mov_es;
	}

	public void setObs_mov_es(String obs_mov_es) {
		this.obs_mov_es = obs_mov_es;
	}

	public int getLote_mov_lote() {
		return lote_mov_lote;
	}

	public void setLote_mov_lote(int lote_mov_lote) {
		this.lote_mov_lote = lote_mov_lote;
	}

	public Date getDt_fab_mov_lote() {
		return dt_fab_mov_lote;
	}

	public void setDt_fab_mov_lote(Date dt_fab_mov_lote) {
		this.dt_fab_mov_lote = dt_fab_mov_lote;
	}

	public String getFornecedor_mov_lote() {
		return fornecedor_mov_lote;
	}

	public void setFornecedor_mov_lote(String fornecedor_mov_lote) {
		this.fornecedor_mov_lote = fornecedor_mov_lote;
	}

	public String getTipo_mov_lote() {
		return tipo_mov_lote;
	}

	public void setTipo_mov_lote(String tipo_mov_lote) {
		this.tipo_mov_lote = tipo_mov_lote;
	}

	public int getNumero_serie_mov_lote() {
		return numero_serie_mov_lote;
	}

	public void setNumero_serie_mov_lote(int numero_serie_mov_lote) {
		this.numero_serie_mov_lote = numero_serie_mov_lote;
	}

	public Date getDt_val_mov_lote() {
		return dt_val_mov_lote;
	}

	public void setDt_val_mov_lote(Date dt_val_mov_lote) {
		this.dt_val_mov_lote = dt_val_mov_lote;
	}

	public String getNome_prod_mov_mult() {
		return nome_prod_mov_mult;
	}

	public void setNome_prod_mov_mult(String nome_prod_mov_mult) {
		this.nome_prod_mov_mult = nome_prod_mov_mult;
	}

	public String getOrigem_mov_mult() {
		return origem_mov_mult;
	}

	public void setOrigem_mov_mult(String origem_mov_mult) {
		this.origem_mov_mult = origem_mov_mult;
	}

	public String getProd_mov_mult() {
		return prod_mov_mult;
	}

	public void setProd_mov_mult(String prod_mov_mult) {
		this.prod_mov_mult = prod_mov_mult;
	}

	public int getLote_mov_mult() {
		return lote_mov_mult;
	}

	public void setLote_mov_mult(int lote_mov_mult) {
		this.lote_mov_mult = lote_mov_mult;
	}

	public String getDoc_mov_mult() {
		return doc_mov_mult;
	}

	public void setDoc_mov_mult(String doc_mov_mult) {
		this.doc_mov_mult = doc_mov_mult;
	}

	public String getDestino_mov_mult() {
		return destino_mov_mult;
	}

	public void setDestino_mov_mult(String destino_mov_mult) {
		this.destino_mov_mult = destino_mov_mult;
	}

	public int getQuantidade_mov_mult() {
		return quantidade_mov_mult;
	}

	public void setQuantidade_mov_mult(int quantidade_mov_mult) {
		this.quantidade_mov_mult = quantidade_mov_mult;
	}

	public int getNumero_serie_mov_mult() {
		return numero_serie_mov_mult;
	}

	public void setNumero_serie_mov_mult(int numero_serie_mov_mult) {
		this.numero_serie_mov_mult = numero_serie_mov_mult;
	}

	public String getObs_mov_mult() {
		return obs_mov_mult;
	}

	public void setObs_mov_mult(String obs_mov_mult) {
		this.obs_mov_mult = obs_mov_mult;
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

	public int getQuantidade_inv_ajustes() {
		return quantidade_inv_ajustes;
	}

	public void setQuantidade_inv_ajustes(int quantidade_inv_ajustes) {
		this.quantidade_inv_ajustes = quantidade_inv_ajustes;
	}

	public String getPreco_inv_ajustes() {
		return preco_inv_ajustes;
	}

	public void setPreco_inv_ajustes(String preco_inv_ajustes) {
		this.preco_inv_ajustes = preco_inv_ajustes;
	}

	public String getPreco_total_inv_ajustes() {
		return preco_total_inv_ajustes;
	}

	public void setPreco_total_inv_ajustes(String preco_total_inv_ajustes) {
		this.preco_total_inv_ajustes = preco_total_inv_ajustes;
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

	public String getNome_inv() {
		return nome_inv;
	}

	public void setNome_inv(String nome_inv) {
		this.nome_inv = nome_inv;
	}

	public String getDescricao_inv() {
		return descricao_inv;
	}

	public void setDescricao_inv(String descricao_inv) {
		this.descricao_inv = descricao_inv;
	}

	public String getQuantidade_estoque_inv() {
		return quantidade_estoque_inv;
	}

	public void setQuantidade_estoque_inv(String quantidade_estoque_inv) {
		this.quantidade_estoque_inv = quantidade_estoque_inv;
	}

	public String getQuantidade_inv() {
		return quantidade_inv;
	}

	public void setQuantidade_inv(String quantidade_inv) {
		this.quantidade_inv = quantidade_inv;
	}

	public String getNome_prod_auto_minmax() {
		return nome_prod_auto_minmax;
	}

	public void setNome_prod_auto_minmax(String nome_prod_auto_minmax) {
		this.nome_prod_auto_minmax = nome_prod_auto_minmax;
	}

	public int getEstoque_min_auto_minmax() {
		return estoque_min_auto_minmax;
	}

	public void setEstoque_min_auto_minmax(int estoque_min_auto_minmax) {
		this.estoque_min_auto_minmax = estoque_min_auto_minmax;
	}

	public int getEstoque_max_auto_minmax() {
		return estoque_max_auto_minmax;
	}

	public void setEstoque_max_auto_minmax(int estoque_max_auto_minmax) {
		this.estoque_max_auto_minmax = estoque_max_auto_minmax;
	}

	public String getNome_auto_giro() {
		return nome_auto_giro;
	}

	public void setNome_auto_giro(String nome_auto_giro) {
		this.nome_auto_giro = nome_auto_giro;
	}

	public String getClass_auto_giro() {
		return class_auto_giro;
	}

	public void setClass_auto_giro(String class_auto_giro) {
		this.class_auto_giro = class_auto_giro;
	}

	public String getTipo_auto_giro() {
		return tipo_auto_giro;
	}

	public void setTipo_auto_giro(String tipo_auto_giro) {
		this.tipo_auto_giro = tipo_auto_giro;
	}

	public String getNome_prod_relatorio_mrp() {
		return nome_prod_relatorio_mrp;
	}

	public void setNome_prod_relatorio_mrp(String nome_prod_relatorio_mrp) {
		this.nome_prod_relatorio_mrp = nome_prod_relatorio_mrp;
	}

	public String getCategoria_relatorio_mrp() {
		return categoria_relatorio_mrp;
	}

	public void setCategoria_relatorio_mrp(String categoria_relatorio_mrp) {
		this.categoria_relatorio_mrp = categoria_relatorio_mrp;
	}

	public String getStatus_relatorio_mrp() {
		return status_relatorio_mrp;
	}

	public void setStatus_relatorio_mrp(String status_relatorio_mrp) {
		this.status_relatorio_mrp = status_relatorio_mrp;
	}

	public String getSugestao_relatorio_mrp() {
		return sugestao_relatorio_mrp;
	}

	public void setSugestao_relatorio_mrp(String sugestao_relatorio_mrp) {
		this.sugestao_relatorio_mrp = sugestao_relatorio_mrp;
	}

	public Date getData_prev_repo_relatorio_mrp() {
		return data_prev_repo_relatorio_mrp;
	}

	public void setData_prev_repo_relatorio_mrp(Date data_prev_repo_relatorio_mrp) {
		this.data_prev_repo_relatorio_mrp = data_prev_repo_relatorio_mrp;
	}

	public String getResponsavel_relatorio_mrp() {
		return responsavel_relatorio_mrp;
	}

	public void setResponsavel_relatorio_mrp(String responsavel_relatorio_mrp) {
		this.responsavel_relatorio_mrp = responsavel_relatorio_mrp;
	}

	public String getJustificativa_relatorio_mrp() {
		return justificativa_relatorio_mrp;
	}

	public void setJustificativa_relatorio_mrp(String justificativa_relatorio_mrp) {
		this.justificativa_relatorio_mrp = justificativa_relatorio_mrp;
	}
}