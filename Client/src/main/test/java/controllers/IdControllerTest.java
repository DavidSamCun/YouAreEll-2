package controllers;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class IdControllerTest {

    @org.junit.jupiter.api.Test
    void getIds() throws IOException, InterruptedException {
        IdController test = new IdController();
        test.getIds();

    }

    @org.junit.jupiter.api.Test
    void postId() {
    }

    @org.junit.jupiter.api.Test
    void putId() {
    }
}