package youareell;

import controllers.*;

import java.io.IOException;

public class YouAreEll {

    TransactionController tt;

    public YouAreEll (TransactionController t) {
        this.tt = t;
    }

    public YouAreEll(MessageController messageController, IdController idController) {
        this.tt = new TransactionController(messageController, idController);
    }

    public static void main(String[] args) {
        // hmm: is this Dependency Injection?
        YouAreEll urlhandler = new YouAreEll(
            new TransactionController(
                new MessageController(), new IdController()
        ));
       // System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
       // System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
    }

    public String get_ids() throws IOException, InterruptedException {
        return tt.getIds().toString();
    }

    public String get_messages() throws IOException, InterruptedException {
        return tt.getMessages().toString();
    }

    public void post_ids(String name, String github) throws IOException, InterruptedException {
        tt.postId(name, github);
    }

}
