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
    private ServerController x = ServerController.getSvr();
    // why a HashSet??To prevent Duplicate messages

    public MessageController(){
        messagesSeen = new HashSet<>();
    }

    public ArrayList<Message> getMessages() throws IOException, InterruptedException {

        HttpResponse<String> reponse = x.createGetConnection("/messages");

        ObjectMapper mapper = new ObjectMapper();
        ArrayList<models.Message> messages = mapper.readValue(reponse.body(), new TypeReference<>() {
        });
        for (Message message: messages) {
            messagesSeen.add(message);
        }

        return messages;
    }
    public ArrayList<Message> getMessagesToId(Id Id) throws IOException, InterruptedException {
        ArrayList<Message> messagesForId = new ArrayList<>();
        for(Message message: this.messagesSeen){
            if(message.getToId().equals(Id.getGithub())){
                messagesForId.add(message);
            }
        }
        return messagesForId;
    }
    public Message getMessageForSequence(String seq) {
        return null;
    }
    public ArrayList<Message> getMessagesFromFriend(Id myId, Id friendId) {
        return null;
    }

    public Message postMessage(Id myId, Id toId, Message msg) throws IOException, InterruptedException {

        msg.setFromid("Bulbasaur");
        msg.setMessage("Test");
        ObjectMapper objectMapper = new ObjectMapper();
        String out = objectMapper.writeValueAsString(msg);
        x.createPostConnection("/messages", out);

        return null;
    }
 
}