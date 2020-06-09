package br.com.endereco;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/enderecos")
public class EnderecosResource {
    @Inject
    EnderecosService enderecosService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{cep}")
    public Endereco buscarEnderecoPorCEP(@PathParam("cep") String cep) {
        Endereco endereco = enderecosService.getEndereco(cep);
        return endereco;
    }
}