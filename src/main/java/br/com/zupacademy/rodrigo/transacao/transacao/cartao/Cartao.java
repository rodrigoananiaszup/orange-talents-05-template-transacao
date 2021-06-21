package br.com.zupacademy.rodrigo.transacao.transacao.cartao;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "cartao")
public class Cartao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String uuid = UUID.randomUUID().toString();

	@NotBlank
	private String email;

	@Deprecated
	public Cartao() {
	}

	public Cartao(@NotBlank String uuid, @NotBlank String email) {
		this.uuid = uuid;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getUuid() {
		return uuid;
	}

	public String getEmail() {
		return email;
	}

}
