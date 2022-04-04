package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import models.Id;
import models.Message;

import java.io.IOException;
import java.util.List;

public class TransactionController {
    private String rootURL = "http://zipcode.rocks:8085";
    private MessageController msgCtrl;
    private IdController idCtrl;

    public TransactionController(MessageController m, IdController j) {
        msgCtrl = m;
        idCtrl = j;
    }

    public List<Id> getIds() throws IOException, InterruptedException {
        return idCtrl.getIds();
    }
    public String postId(String idtoRegister, String githubName) throws IOException, InterruptedException {
        Id tid = new Id(idtoRegister, githubName);
        tid = idCtrl.postId(tid);
        return ("Id registered.");
    }
    public List<Message> getMessages() throws IOException, InterruptedException {
        return msgCtrl.getMessages();
    }

    public void postMessage() throws IOException, InterruptedException {
        Id test1 = new Id();
        Id test2 = new Id();
        Message msg = new Message();
        msgCtrl.postMessage(test1, test2, msg);
    }
}
