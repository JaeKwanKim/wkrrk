package sample.model;

import sample.Process.SHA256.SHA256;

import java.io.Serializable;
import java.util.*;

/**
 * Created by JKKim on 2016. 5. 27..
 */
public class UserMain implements Serializable {
    private Long userNum;
    private String userId;
    private String password;
    private String alias;
    private UserInfo userInfo;
    private UserAccessInfo userAccessInfo;
    private List<ProjectMain> projectMainList;
    private Map<String, Object> _links;
//    @JoinColumn(referencedColumnName = "userId")

    public UserMain() { }

    public Long getUserNum() {
        return userNum;
    }

    public void setUserNum(Long userNum) {
        this.userNum = userNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserAccessInfo getUserAccessInfo() {
        return userAccessInfo;
    }

    public void setUserAccessInfo(UserAccessInfo userAccessInfo) {
        this.userAccessInfo = userAccessInfo;
    }

    public List<ProjectMain> getProjectMainList() {
        return projectMainList;
    }

    public void setProjectMainList(List<ProjectMain> projectMainList) {
        this.projectMainList = projectMainList;
    }

    public Map<String, Object> get_links() {
        return _links;
    }

    public void set_links(Map<String, Object> _links) {
        this._links = _links;
    }

    public String SHAEncoder(String shaText) {
        return SHA256.setSHA256(shaText);
    }

    @Override
    public String toString() {
        return "유저넘버 : " + getUserNum() + "\n" +
                "유저아이디 : " + getUserId() + "\n" +
                "유저별칭 : " + getAlias() + "\n";

    }
}
