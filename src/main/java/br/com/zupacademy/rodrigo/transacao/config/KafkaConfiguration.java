package br.com.zupacademy.rodrigo.transacao.config;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.zupacademy.rodrigo.transacao.transacao.Transacao;
import br.com.zupacademy.rodrigo.transacao.transacao.TransacaoRepository;
import br.com.zupacademy.rodrigo.transacao.transacao.TransacaoRequest;

@Component
public class KafkaConfiguration {

	
	private final TransacaoRepository transacaoRepository;
	

	public KafkaConfiguration(TransacaoRepository transacaoRepository) {
		this.transacaoRepository = transacaoRepository;
	}

	Logger logger = LoggerFactory.getLogger(KafkaConfiguration.class);
	
	@Bean
	JsonMessageConverter jsonMessageConverter() {
		return new JsonMessageConverter();
	}

	@KafkaListener(topics = "${spring.kafka.topic.transacoes}")
	public void ouvir(@Valid @Payload TransacaoRequest transacaoRequest) {
		Transacao transacao = transacaoRequest.toModel();
		transacaoRepository.save(transacao);
		logger.info("Transação " + transacaoRequest.getId() + " salva com sucesso.");
	}
}