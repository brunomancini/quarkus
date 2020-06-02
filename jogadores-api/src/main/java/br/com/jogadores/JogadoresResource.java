package br.com.jogadores;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/jogadores")
public class JogadoresResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Jogador> getJogadores() {
        Jogador jogador = new Jogador();
        jogador.setIdade(34);
        jogador.setNome("Mancini");
        return Arrays.asList(jogador);
    }
}