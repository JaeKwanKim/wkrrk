package sample.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Created by JKKim on 2016. 6. 11..
 */
public class UserAccessInfo implements Serializable{
    private Long userNum;
    private Date first;
    private Date last;
    private String ip;
    private Map<String, Object> _links;


    public Long getUserNum() {
        return userNum;
    }

    public void setUserNum(Long userNum) {
        this.userNum = userNum;
    }

    public Date getFirst() {
        return first;
    }

    public void setFirst(Date first) {
        this.first = first;
    }

    public Date getLast() {
        return last;
    }

    public void setLast(Date last) {
        this.last = last;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Map<String, Object> get_links() {
        return _links;
    }

    public void set_links(Map<String, Object> _links) {
        this._links = _links;
    }
}
