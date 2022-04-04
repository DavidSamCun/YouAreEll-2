package models;

/* 
 * POJO for an Message object
 *
 *   {
    "sequence": "-",
    "timestamp": "_",
    "fromid": "xt0fer",
    "toid": "kristofer",
    "message": "Hello, Kristofer!"
  },

*
 */
public class Message implements Comparable {

    private String message = "-";
    private String toid = "-";
    private String fromid = "-";
    private String timestamp = "-";
    private String sequence = "-";

    public Message(){}

    public Message (String message, String fromId, String toId) {
        this.message = message;
        this.fromid = fromId;
        this.toid = toId;
    }

    public Message (String message, String fromId) {
        this.message = message;
        this.fromid = fromId;
        this.toid = "";
    }

    @Override
    public String toString() {
        return "to: " + this.toid + "\nfrom: "+ this.fromid + "\n" + this.message + "\n----\n";
    }

    public int compareTo(Object o) {
        return this.sequence.compareTo(((Message) o).getSequence());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToId() {
        return toid;
    }

    public void setToid(String toid) {
        this.toid = toid;
    }

    public String getFromid() {
        return fromid;
    }

    public void setFromid(String fromid) {
        this.fromid = fromid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp){
        this.timestamp = timestamp;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
}