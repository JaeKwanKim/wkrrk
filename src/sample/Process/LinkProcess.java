package sample.Process;

import com.fasterxml.jackson.databind.ObjectMapper;
import sample.model.UserAccessInfo;
import sample.model.UserInfo;
import sample.model.UserMain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by JKKim on 2016. 6. 12..
 */
public class LinkProcess {
    private ObjectMapper mapper = new ObjectMapper();
    private UserMain userMain;
    public LinkProcess(UserMain user) {
        userMain = user;
    }

    public UserMain setUserMain() throws IOException {
        Map<String, Object> link = userMain.get_links();

        userMain.setUserInfo(setUserInfo(link));
        userMain.setUserAccessInfo(setUserAccessInfo(link));
        userMain.getUserInfo().setUserNum(userMain.getUserNum());
        userMain.getUserAccessInfo().setUserNum(userMain.getUserNum());

        return userMain;
    }

    private UserInfo setUserInfo(Map<String, Object> link) throws IOException {
        Map<String, String> userInfoLink = (Map<String, String>) link.get("userInfo");
        URL url = new URL(userInfoLink.get("href"));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type","application/json;charset=UTF-8");
        conn.setRequestProperty("Accept", "application/json");

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        return mapper.readValue(br, UserInfo.class);
    }

    private UserAccessInfo setUserAccessInfo(Map<String, Object> link) throws IOException {
        Map<String, String> AccessInfo = (Map<String, String>) link.get("userAccessInfo");
        URL url = new URL(AccessInfo.get("href"));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type","application/json;charset=UTF-8");
        conn.setRequestProperty("Accept", "application/json");

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        return mapper.readValue(br, UserAccessInfo.class);
    }

}
