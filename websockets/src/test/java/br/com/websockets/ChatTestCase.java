package br.com.websockets;

import java.net.URI;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ChatTestCase {

    private static final LinkedBlockingDeque<String> MESSAGES = new LinkedBlockingDeque<>();

    @TestHTTPResource("/chat/mancini")
    URI uri;

    @Test
    public void testWebsocketChat() throws Exception {
        try (Session session = ContainerProvider.getWebSocketContainer().connectToServer(Client.class, uri)) {
            Assertions.assertEquals("CONECTANDO", MESSAGES.poll(8, TimeUnit.SECONDS));
            Assertions.assertEquals("Usuário mancini conectado", MESSAGES.poll(8, TimeUnit.SECONDS));
            session.getAsyncRemote().sendText("olá mundo");
            Assertions.assertEquals(">> mancini: olá mundo", MESSAGES.poll(8, TimeUnit.SECONDS));
        }
    }

    @ClientEndpoint
    public static class Client {

        @OnOpen
        public void open(Session session) {
            MESSAGES.add("CONECTANDO");
            session.getAsyncRemote().sendText("pronto");
        }

        @OnMessage
        void message(String msg) {
            MESSAGES.add(msg);
        }
    }

}
