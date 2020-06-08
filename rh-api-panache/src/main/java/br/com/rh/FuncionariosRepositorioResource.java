package br.com.rh;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/repositorio/funcionarios")
public class FuncionariosRepositorioResource {
    @Inject
    FuncionarioRepositorio repositorio;

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Funcionario criar(Funcionario funcionario) {
        repositorio.persist(funcionario);
        return funcionario;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Funcionario> listar() {
        return repositorio.listAll();
    }

    @PUT
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Funcionario alterar(@PathParam("id") Long id, Funcionario funcionario) {
        repositorio.update(
                "update from Funcionario set cpf = ?2, email = ?3, estado = ?4, idade = ?5, nome = ?6, telefone = ?7 where id = ?1",
                id, funcionario.getCpf(), funcionario.getEmail(), funcionario.getEstado(), funcionario.getIdade(),
                funcionario.getNome(), funcionario.getTelefone());
        return funcionario;
    }

    @DELETE
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void deletar(@PathParam("id") Long id) {
        repositorio.deleteById(id);
        repositorio.deleteById(id);
    }
}