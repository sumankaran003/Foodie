package in.karan.suman.foodka.Model;

/**
 * Created by Suman on 24-Apr-18.
 */

public class Offer {

    public String head,detail;

    public Offer() {
    }

    public Offer(String head, String detail) {
        this.head = head;
        this.detail = detail;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
