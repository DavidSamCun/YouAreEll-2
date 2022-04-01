package youareell;

import controllers.*;

public class YouAreEll {

    MessageController messageController;
    IdController idController;

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
        System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
        System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
    }

    public String get_ids() {
        return tt.makecall("/ids", "GET", "");
    }

    public String get_messages() {
        return MakeURLCall("/messages", "GET", "");
    }


}
