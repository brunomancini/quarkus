package br.com.rh;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/funcionarios")
public class FuncionariosResource {
    @Inject
    FuncionarioRepositorio repositorio;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Funcionario criar(Funcionario funcionario) {
        return repositorio.save(funcionario);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Funcionario> listar() {
        return repositorio.findAll();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Funcionario alterar(@PathParam("id") Long id, Funcionario funcionario) {
        funcionario.setId(id);
        return repositorio.save(funcionario);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void deletar(@PathParam("id") Long id) {
        repositorio.deleteById(id);
    }
}