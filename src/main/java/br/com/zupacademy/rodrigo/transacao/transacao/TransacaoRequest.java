package br.com.zupacademy.rodrigo.transacao.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zupacademy.rodrigo.transacao.transacao.cartao.Cartao;
import br.com.zupacademy.rodrigo.transacao.transacao.cartao.CartaoRequest;
import br.com.zupacademy.rodrigo.transacao.transacao.estabelecimento.EstabelecimentoTransacao;
import br.com.zupacademy.rodrigo.transacao.transacao.estabelecimento.EstabelecimentoTransacaoRequest;

public class TransacaoRequest {

	@NotBlank
	private String id;

	@NotNull
	@Positive
	private BigDecimal valor;

	@NotNull
	@Valid
	private EstabelecimentoTransacaoRequest estabelecimento;

	@NotNull
	@Valid
	private CartaoRequest cartao;

	@NotNull
	private LocalDateTime efetivadaEm;
	
	@Deprecated
	public TransacaoRequest() {
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EstabelecimentoTransacaoRequest getEstabelecimento() {
		return estabelecimento;
	}

	public CartaoRequest getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}
	
	public Transacao toModel() {
		Cartao cartao = this.cartao.toModel();
		EstabelecimentoTransacao estabelecimento = this.estabelecimento.toModel();
		return new Transacao(this.id, this.valor, estabelecimento, cartao, this.efetivadaEm);
	}

}
