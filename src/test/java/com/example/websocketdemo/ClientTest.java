package com.example.websocketdemo;

import org.junit.Test;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import java.net.URI;

public class ClientTest {

    @Test
    public void testSendingOfData(){
        WebSocketClient client = new StandardWebSocketClient();
        String uri = "ws://localhost:8080/socket";
        WebSocketConnectionManager webSocketConnectionManager = new WebSocketConnectionManager(client, new MessagingWebSocketHandler(), uri);
        webSocketConnectionManager.start();
    }
}
