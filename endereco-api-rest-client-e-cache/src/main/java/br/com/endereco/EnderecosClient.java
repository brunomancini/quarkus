package br.com.endereco;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
@Path("/ws")
public interface EnderecosClient {
    @GET
    @Path("/{cep}/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Endereco getEndereco(@PathParam(value = "cep") String cep);
}
