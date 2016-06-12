package test.sample;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.stream.writers.UTF8OutputStreamWriter;
import org.junit.Before;
import org.junit.Test;
import sample.Process.FindLocalIP;
import sample.Process.LinkProcess;
import sample.model.UserAccessInfo;
import sample.model.UserInfo;
import sample.model.UserMain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by JKKim on 2016. 6. 12..
 */
public class UserTest {
    private UserMain userMain;
    private UserInfo userInfo;
    private UserAccessInfo userAccessInfo;

    @Before public void init() {
        userMain = new UserMain();
        userInfo = new UserInfo();
        userAccessInfo = new UserAccessInfo();
    }

    @Test public void InsertUserTest() throws IOException {
//        userMain.setUserNum(1L);
        userMain.setUserId("aaaa");
        userMain.setPassword(userMain.SHAEncoder("aa12"));
        userMain.setAlias("천재임다.");

        userInfo.setUserNum(1L);
        userInfo.setFirstName("김");
        userInfo.setLastName("재관");
        userInfo.setBirthday(new Date(79-10-23));
        userInfo.setSex(1);
        userInfo.setEmail("jk79thor@icloud.com");
        userInfo.setPhone1("010-9501-4697");
        userInfo.setCountry("82");
        userInfo.setRegion("제주도");
        userInfo.setCity("제주시");

        userAccessInfo.setUserNum(1L);
        userAccessInfo.setFirst(new Date());
        userAccessInfo.setLast(new Date());
        userAccessInfo.setIp(FindLocalIP.getLocalServerIp());

        userMain.setUserInfo(userInfo);
        userMain.setUserAccessInfo(userAccessInfo);

        System.out.println(userAccessInfo.getIp());
//        SendPostUserInfo(userMain);
    }

    @Test
    public void SearchUserData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL("http://localhost:8080/user_main/search/byId?id=aaaa&projection=userProjection");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type","application/json;charset=UTF-8");
        conn.setRequestProperty("Accept", "application/json");

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = br.readLine()) != null) {
            response.append(inputLine);
        }
//        System.out.println(response.toString());

        UserMain user = new LinkProcess(mapper.readValue(response.toString(), UserMain.class)).setUserMain();

        System.out.println("이메일 : " + user.getUserInfo().getEmail() + "\n생성시간 : " + user.getUserAccessInfo().getFirst()
                + "\n번호 : " + user.getUserInfo().getUserNum() + "/" + user.getUserAccessInfo().getUserNum());
        assertThat(user.getUserNum(), is(1L));
    }


    private void SendPostUserInfo(UserMain userMain) throws IOException {
        URL url = new URL("http://localhost:8080/user");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type","application/json;charset=UTF-8");
        conn.setRequestProperty("Accept", "application/json");

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(userMain);
        System.out.println(jsonInString);

        conn.setDoOutput(true);
        UTF8OutputStreamWriter stream = new UTF8OutputStreamWriter(conn.getOutputStream());
        stream.write(jsonInString);
        stream.flush();
        stream.close();

        int responseCode = conn.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("POST request not worked");
        }

        conn.disconnect();
    }

}
