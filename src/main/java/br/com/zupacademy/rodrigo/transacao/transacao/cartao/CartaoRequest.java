package br.com.zupacademy.rodrigo.transacao.transacao.cartao;

import javax.validation.constraints.NotBlank;

public class CartaoRequest {

	@NotBlank
	private String id;

	@NotBlank
	private String email;

	@Deprecated
	public CartaoRequest() {
	}

	public CartaoRequest(@NotBlank String id, @NotBlank String email) {
		this.id = id;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public Cartao toModel() {
		return new Cartao(this.id, this.email);
	}
}
