package br.com.websockets;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.jboss.logging.Logger;

@ServerEndpoint("/chat/{user}")
@ApplicationScoped
public class ChatSocket {

    private static final Logger LOG = Logger.getLogger(ChatSocket.class);

    Map<String, Session> sessions = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("user") String user) {
        sessions.put(user, session);
    }

    @OnClose
    public void onClose(Session session, @PathParam("user") String user) {
        sessions.remove(user);
        broadcast("Usuário " + user + " saiu");
    }

    @OnError
    public void onError(Session session, @PathParam("user") String user, Throwable throwable) {
        sessions.remove(user);
        LOG.error("ERRO: ", throwable);
        broadcast("Usuário " + user + " saiu com erro: " + throwable);
    }

    @OnMessage
    public void onMessage(String message, @PathParam("user") String user) {
        if (message.equalsIgnoreCase("pronto")) {
            broadcast("Usuário " + user + " conectado");
        } else {
            broadcast(">> " + user + ": " + message);
        }
    }

    private void broadcast(String message) {
        sessions.values().forEach(s -> {
            s.getAsyncRemote().sendObject(message, result -> {
                if (result.getException() != null) {
                    System.out.println("Erro ao enviar mensagem: " + result.getException());
                }
            });
        });
    }

}