package controllers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//public class ServerController() {
public class ServerController {
    private static String rootURL = "http://zipcode.rocks:8085";

    private ServerController svr = new ServerController();

    private ServerController() {}

    public static HttpRequest shared(String resource) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(rootURL+resource))
                .build();
        return request;

    }

    public HttpResponse<String> idGet() throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = shared("/ids");

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response;


        // url -> /ids/
        // send the server a get with url
        // return json from server

/*        String temp = "";
        URL url = new URL("url");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        if (conn.getResponseCode() == 200) {
            Scanner scan = new Scanner(url.openStream());
            while (scan.hasNext()) {
                temp = scan.nextLine();
            }
        }
        System.out.println(temp);
        return temp;*/


    }


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