package controllers;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;

public class IdController {
    private HashMap<String, Id> mapIds;
    private ArrayList<Id> listIds;
    Id myId;

    public IdController(){
        mapIds = new HashMap<>();
        listIds = new ArrayList<>();
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

        return ids;
    }

    private ArrayList<Id> getListIds() throws IOException, InterruptedException {
        listIds = getIds();
        return listIds;
    }

    public Id postId(Id id) {


        return null;
    }

    public Id putId(Id id) {
        return null;
    }
 
}