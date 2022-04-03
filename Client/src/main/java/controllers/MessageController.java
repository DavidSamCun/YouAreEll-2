package controllers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.Message;

public class MessageController {

    private HashSet<Message> messagesSeen;
    // why a HashSet?? To prevent duplicates

    public List<Message> getMessages() throws IOException, InterruptedException {
        String rootURLiDs = "http://zipcode.rocks:8085/messages";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(rootURLiDs))
                .build();

        //Currently I can get something to fill response. Need to parse it somehow
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        //parse JSON into Objects
        ObjectMapper mapper = new ObjectMapper();
        //List<models.Message> posts = mapper.readValue(response.body(), new TypeReference<>() {});
        List<models.Message> messageList = mapper.readValue(response.body(), new TypeReference<List<Message>>() {});
        return messageList;
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

    //My methods
    public void getMessageTest() throws IOException, InterruptedException {
        String rootURLiDs = "http://zipcode.rocks:8085/messages";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(rootURLiDs))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());

        //parse JSON into Objects
        ObjectMapper mapper = new ObjectMapper();
        List<Id> posts = mapper.readValue(response.body(), new TypeReference<>() {
        });

    }
 
}