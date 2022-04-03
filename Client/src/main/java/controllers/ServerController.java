package controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ServerController {
    private String rootURL = "http://zipcode.rocks:8085";

    private static ServerController svr = new ServerController();

    public static ServerController getSvr(){
        return svr;
    }

    //resource is ids or messages
    public HttpResponse<String> createGetConnection(String resource) throws IOException, InterruptedException {

        String urlToUri = rootURL + resource;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(urlToUri))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response;
    }

    private void createPostConnection(String resource, String output) throws IOException, InterruptedException {

        String urlToUri = rootURL + resource;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .header("accept", "application/json")
                .uri(URI.create(urlToUri))
                .POST(HttpRequest.BodyPublishers.ofString(output))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    }
//

//    public JsonString idGet() {
//        // url -> /ids/
//        // send the server a get with url
//        // return json from server
//    }
//    public JsonString idPost(Id) {
//        // url -> /ids/
//        // create json from Id
//        // request
//        // reply
//        // return json
//    }
//    public JsonString idPut(Id) {
//        // url -> /ids/
//    }



}

// ServerController.shared.doGet()