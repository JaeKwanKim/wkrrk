package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import sample.model.UserMain;

import java.net.URL;
import java.util.ResourceBundle;

import static sample.Main.manager;

/**
 * Created by JKKim on 2016. 6. 7..
 */
public class RootController implements Initializable{
    @FXML private BorderPane rootpane;
    @FXML private Text root_text;

    private ResourceBundle resourceBundle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        resourceBundle = resources;
        root_text.setText("FXML Start!!");
    }

    public void actionText() {
        UserMain userMain = (UserMain) manager.get("userMain");
        String message = (String) manager.get("message");
//        System.out.println("이메일 : ");
        root_text.setText(message);
    }
}

