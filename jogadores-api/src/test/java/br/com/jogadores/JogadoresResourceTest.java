package br.com.jogadores;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class JogadoresResourceTest {
    @Test
    public void testJogadoresEndpoint() {
        given()
          .when().get("/jogadores")
          .then()
             .statusCode(200)
             .body(
                 "size()", is(1),
                 "[0].nome", is("Mancini"),
                 "[0].idade", is(34)
             );
    }
}