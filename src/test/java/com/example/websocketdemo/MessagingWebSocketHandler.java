package com.example.websocketdemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;


// https://github.com/pecelerowicz/CurrencyTrackerApplication/blob/157c31f80bc9153ddc294bc8ef7ae77042e83311/src/main/java/com/mpecel/currency/websocket/CurrencyWebSocketHandler.java
public class MessagingWebSocketHandler extends TextWebSocketHandler {



    private static final Logger log = LogManager.getLogger(MessagingWebSocketHandler.class);

    public MessagingWebSocketHandler() {

    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        log.info("Received message: " +  message.getPayload());
        session.sendMessage(new TextMessage("From the client"));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws IOException {
        log.info("Connection established");
        session.sendMessage(new TextMessage("We have subscribed"));
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) {
        log.error("Transport error");
        exception.printStackTrace();
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status){
        log.info("Closed connection: " + status.getReason());
    }

}

