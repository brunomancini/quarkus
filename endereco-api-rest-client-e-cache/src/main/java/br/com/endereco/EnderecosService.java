package br.com.endereco;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.cache.CacheResult;

@ApplicationScoped
public class EnderecosService {
    final Logger log = LoggerFactory.getLogger(EnderecosService.class);

    @RestClient
    @Inject
	EnderecosClient enderecoClient;
    
    @CacheResult(cacheName = "endereco-cache")
    public Endereco getEndereco(String cep) {
        Endereco endereco = enderecoClient.getEndereco(cep);
       log.info("Fez a chamada na API de endereços: " + cep);
        return endereco;
    }
}