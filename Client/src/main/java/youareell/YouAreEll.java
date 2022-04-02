package youareell;

import controllers.*;
import models.Id;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class YouAreEll {

    public MessageController messageController;
    public IdController idController;

    TransactionController tt;

    public YouAreEll (TransactionController t) {
        this.tt = t;
    }

    // I made this
    public YouAreEll(MessageController messageController, IdController idController) {
        this.messageController = messageController;
        this.idController = idController;
    }

    public static void main(String[] args) {
        // hmm: is this Dependency Injection?
        YouAreEll urlhandler = new YouAreEll(new TransactionController(new MessageController(), new IdController()));
//        System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
//        System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
    }

    public String get_ids() throws IOException, InterruptedException {
        List<Id> ids = tt.getIds();

        return ids.toString();
    }

//    public String get_messages() {
//        return MakeURLCall("/messages", "GET", "");
//    }


}
