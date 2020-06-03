package br.com.rh;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("funcionarios")
public class FuncionariosResource {
    @Inject
    Validator validator;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("validando-usando-anotacao")
    public Funcionario criarFuncionarioValid(@Valid Funcionario funcionario) {
        return funcionario;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("validando-sem-anotacao")
    public Funcionario criarFuncionario(Funcionario funcionario) throws Exception {
        Set<String> mensagens = validator.validate(funcionario).stream().map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());
        if (mensagens.size() > 0) {
            throw new Exception(Arrays.toString(mensagens.toArray()));
        }        
        return funcionario;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("tratando-excecao")
    public Funcionario criarFuncionarioExcecao(Funcionario funcionario) throws Exception {
        Set<String> mensagens = validator.validate(funcionario).stream().map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());
        throw new BadRequestException(Arrays.toString(mensagens.toArray()));
    }
}