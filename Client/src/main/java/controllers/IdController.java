package controllers;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;

public class IdController {

    private HashMap<String, Id> allIds;

    Id myId;

    //This was ArrayList
    public List<Id> getIds() throws IOException, InterruptedException {

        //Convert stuff from here toooooooooooooooooooo
        String rootURL = "http://zipcode.rocks:8085/ids";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(rootURL))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //Here into a singleton class and have the bottom stuff access it.

        //parse JSON into Objects
        ObjectMapper mapper = new ObjectMapper();
        List<models.Id> ids = mapper.readValue(response.body(), new TypeReference<>() {});
        ids.forEach(System.out::println);
        return ids;
    }


    //Super Beta Mode
    public Id postId(Id id) throws IOException, InterruptedException {

        ObjectMapper objectMapper = new ObjectMapper();
        Id values = new Id("testMonkeh", "Ashes' PrimeApe", "SuperTest");
        String output = objectMapper.writeValueAsString(values);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://zipcode.rocks:8085/ids"))
                .POST(HttpRequest.BodyPublishers.ofString(output))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());



        // create json from id
        // call server, get json result Or error
        // result json to Id obj

        return values;
    }

    public Id putId(Id id) {
        return null;
    }

    public void getiDtest() throws IOException, InterruptedException {
        String rootURLiDs = "http://zipcode.rocks:8085/ids";
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

        //posts.forEach(System.out::println);
    }

}