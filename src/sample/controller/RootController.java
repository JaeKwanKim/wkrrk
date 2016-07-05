package sample.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.model.UserMain;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.cacheManager;

/**
 * Created by JKKim on 2016. 6. 7..
 */
public class RootController implements Initializable{
    @FXML private TextArea root_text;
    @FXML private VBox rootpane;
    @FXML private MenuBar menuBar;
    @FXML private MenuItem LoginMenu;

    private UserMain userMain = (UserMain) cacheManager.get("userMain");
    private String message = (String) cacheManager.get("message");
//    private Popup popup;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        menuBar.setId("Writer");
        menuBar.setUseSystemMenuBar(true);
//        menuBar.useSystemMenuBarProperty().set(true);
    }

    public RootController() {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/RootView.fxml"));
//        fxmlLoader.setRoot(this);
//        fxmlLoader.setController(this);

//        try {
//            fxmlLoader.load();
//        } catch (IOException exception) {
//            throw new RuntimeException(exception);
//        }
//        Task task = new Task() {
//            @Override
//            protected Object call() throws Exception {
//                while(true) {
//                    if (userMain != null) {
//                        Stage stage = (Stage) (rootpane.getScene().getWindow());
//                        stage.setTitle("사용자 (" + userMain.getAlias() + " )");
//                        System.out.println(userMain.getAlias());
//                    }
//                    System.out.println(userMain.getAlias()+"if not..");
//                    updateTitle("사용자 (" + userMain.getAlias() + " )");
//                    return null;
//                }
//            }
//        };
//        new Thread(task).start();
    }

    @FXML
    public void actionText() {
//        System.out.println("이메일 : ");
    }

    @FXML
    public void LoginState() {
        if(LoginMenu.getText().equals("Login")) {
            Stage dialog = new Stage(StageStyle.UTILITY);
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.initOwner(rootpane.getScene().getWindow());
            dialog.setTitle("Login Page");
//        popup = new Popup();
            Parent parent = null;
            try {
                parent = FXMLLoader.load(getClass().getResource("../view/LoginView.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Button btn_close = (Button) parent.lookup("#btn_close");
            btn_close.setOnMouseReleased(event -> {
                dialog.close();
            });
            Scene scene = new Scene(parent, 320, 350);
            dialog.setScene(scene);
            dialog.setResizable(false);
//        popup.getContent().add(parent);
//        popup.setAutoHide(true);//다른 윈도우로 포커스를 이동하면 popup자동 닫힘.
//        Stage stage = (Stage) rootpane.getScene().getWindow();
            LoginMenu.setText("LogOut");
            dialog.show();
        } else {
            userMain = null;
            cacheManager.clear();
            LoginMenu.setText("Login");
        }
        //Stage > Scene > Container(Group) > Node 순...
    }


    public void handleKeyInput(Event event) {
        if (event instanceof KeyEvent)
        {
            final KeyEvent keyEvent = (KeyEvent) event;
            if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.A)
            {
                provideAboutFunctionality();
            }
        }
    }

    public void handleAboutAction(ActionEvent actionEvent) {
        provideAboutFunctionality();
    }

    private void provideAboutFunctionality()
    {
        System.out.println("You clicked on About!");
    }
}

