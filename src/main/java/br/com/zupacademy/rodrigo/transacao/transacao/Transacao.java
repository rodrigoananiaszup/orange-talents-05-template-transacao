package br.com.zupacademy.rodrigo.transacao.transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zupacademy.rodrigo.transacao.transacao.cartao.Cartao;
import br.com.zupacademy.rodrigo.transacao.transacao.estabelecimento.EstabelecimentoTransacao;

@Entity
@Table(name = "transacao")
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String uuid = UUID.randomUUID().toString();

	@NotNull
	@Positive
	private BigDecimal valor;

	@NotNull
	@Valid
	@OneToOne(cascade = CascadeType.PERSIST)
	private EstabelecimentoTransacao estabelecimento;

	@NotNull
	@Valid
	@OneToOne(cascade = CascadeType.PERSIST)
	private Cartao cartao;

	@NotNull
	private LocalDateTime efetivadoEm;

	public Transacao(@NotBlank String uuid, @NotNull @Positive BigDecimal valor,
			EstabelecimentoTransacao estabelecimento, Cartao cartao, @NotNull LocalDateTime efetivadoEm) {
		this.uuid = uuid;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadoEm = efetivadoEm;
	}

	public Long getId() {
		return id;
	}

	public String getUuid() {
		return uuid;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EstabelecimentoTransacao getEstabelecimento() {
		return estabelecimento;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadoEm() {
		return efetivadoEm;
	}

}
