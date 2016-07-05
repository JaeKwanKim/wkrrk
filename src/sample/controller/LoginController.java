package sample.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import sample.Process.LinkProcess;
import sample.model.UserMain;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import static sample.Main.cacheManager;

public class LoginController extends GridPane {
    @FXML private GridPane loginpane;
    @FXML private Text actiontarget;
    @FXML private TextField userid;
    @FXML private PasswordField userpassword;

    private final ObjectMapper mapper =  new ObjectMapper();

    public LoginController() {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/LoginView.fxml"));
//        fxmlLoader.setRoot(this);
//        fxmlLoader.setController(this);
//
//        try {
//            fxmlLoader.load();
//        } catch (IOException exception) {
//            throw new RuntimeException(exception);
//        }
    }

    @FXML
    public void handleSubmitButtonAction(ActionEvent actionEvent) throws IOException {

        URL url = new URL("http://localhost:8080/user_main/search/byId?projection=userProjection&id=" + userid.getText());
        // GET 외에 POST, DELETE, PUT 형식으로 받을때 사용..
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//        conn.setRequestProperty("Accept", "application/json");
//
//        if (conn.getResponseCode() != 200) {
//            throw new RuntimeException("Failed : HTTP error code : "
//                    + conn.getResponseCode());
//        }
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(
//                (conn.getInputStream())));
//
//        JsonFactory factory = new JsonFactory();
//        JsonParser parser  = factory.createParser(br);
//
//        String output;
//        System.out.println("Output from Server .... \n");
//        while ((output = br.readLine()) != null) {
//            System.out.println(output);
//        }

        try {
            UserMain user = mapper.readValue(url, UserMain.class);
            if (user.getPassword().equals(user.SHAEncoder(userpassword.getText()))) {
//                System.out.println(user);
                actiontarget.setText(user.getAlias());
                AfterLoginAndPageLoding((new LinkProcess(user)).setUserMain());
            } else {
                actiontarget.setText("패스워드가 잘못 입력되었습니다");
            }
        }catch(FileNotFoundException e) {
            actiontarget.setText("사용자를 찾을 수 없습니다.");
        }

//        conn.disconnect();


        /*List 타입의 콜렉션으로 받을때..
        List<Employee> list = mapper.readValue(jsonString,
        TypeFactory.defaultInstance().constructCollectionType(List.class,
                Employee.class));

        ** POST 방식으로 보낼때 **
        URL url = new URL("http://localhost:8080/RESTfulExample/json/product/post");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");

		String input = "{\"qty\":100,\"name\":\"iPad 4\"}";

		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();

		if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
			throw new RuntimeException("Failed : HTTP error code : "
				+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();
         */
    }

    private void AfterLoginAndPageLoding(UserMain userMain) throws IOException {
//        BorderPane pane = (BorderPane) getParent().lookup("#rootpane");
//        Stage stage = (Stage) pane.getScene().getWindow();
//        stage.close();
        cacheManager.put("userMain", userMain);
        cacheManager.put("message", "hello world");
        System.out.println(userMain);
//        stage.setTitle("사용자( "+ userMain.getAlias() + " )");
//      이벤트 설정하기
//        EventHandler eventHandler = (EventHandler<WindowEvent>) event -> {
//
//        };
//
//        stage.setOnHiding(eventHandler);

    }
}

