package br.com.rh;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RHExceptionMapper implements ExceptionMapper<BadRequestException> {

    @Override
    public Response toResponse(BadRequestException badReqException) {
        RHExcecao nossaExcecao = new RHExcecao();
        nossaExcecao.setMensagem(badReqException.getMessage());
        return Response.status(Status.BAD_REQUEST).entity(nossaExcecao).build();
    }
}