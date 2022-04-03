package controllers;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;

public class IdController {
    private HashMap<String, Id> mapIds;
    private HashSet<Id> listIds;
    Id myId;

    public IdController(){
        mapIds = new HashMap<>();
        listIds = new HashSet<>();
    }

    public ArrayList<Id> getIds() throws IOException, InterruptedException {
        ServerController x = ServerController.getSvr();
        HttpResponse<String> reponse = x.createGetConnection("/ids");

        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Id> ids = mapper.readValue(reponse.body(), new TypeReference<>() {
        });

        for (Id id: ids){
            mapIds.put(id.getGithub(), id);
        }

        for (Id id: ids) {
            listIds.add(id);
        }

        return ids;
    }

    private HashSet<Id> getListIds() throws IOException, InterruptedException {
        return listIds;
    }

    public Id postId(Id id) throws IOException, InterruptedException {

        ObjectMapper objectMapper = new ObjectMapper();
        String output = objectMapper.writeValueAsString(id);
        ServerController x = ServerController.getSvr();
        x.createPostConnection("/ids", output);
        return id;
    }

    public Id putId(Id id) {
        return null;
    }
 
}