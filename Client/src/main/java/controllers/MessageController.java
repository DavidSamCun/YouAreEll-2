package controllers;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashSet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.Message;

public class MessageController {

    private HashSet<Message> messagesSeen;
    // why a HashSet??

    public MessageController(){
        messagesSeen = new HashSet<>();
    }

    public ArrayList<Message> getMessages() throws IOException, InterruptedException {

        ServerController x = ServerController.getSvr();
        HttpResponse<String> reponse = x.createGetConnection("/messages");

        ObjectMapper mapper = new ObjectMapper();
        ArrayList<models.Message> messages = mapper.readValue(reponse.body(), new TypeReference<>() {
        });
        for (Message message: messages) {
            messagesSeen.add(message);
        }

        return messages;
    }
    public ArrayList<Message> getMessagesForId(Id Id) {


        return null;
    }
    public Message getMessageForSequence(String seq) {
        return null;
    }
    public ArrayList<Message> getMessagesFromFriend(Id myId, Id friendId) {
        return null;
    }

    public Message postMessage(Id myId, Id toId, Message msg) {
        return null;
    }
 
}