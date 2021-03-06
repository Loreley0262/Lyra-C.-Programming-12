package Layout;

import Database.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Addmember implements Initializable {
    public TextField getId;
    public TextField getName;
    public TextField getEmail;
    public TextField getNick;
    public DatabaseHandler handler;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        handler = new DatabaseHandler();
    }


    public void addMember(ActionEvent actionEvent) {
        String n = getName.getText();
        String i = getId.getText();
        String email = getEmail.getText();
        String nick = getNick.getText();

        boolean flag = n.isEmpty() || i.isEmpty() || email.isEmpty() || nick.isEmpty();
        if (flag){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please enter all fields");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }
        String st = "INSERT INTO MEMBER VALUES (" +
                "'" + i + "'," +
                "'" + n + "'," +
                "'" + email + "'," +
                "'" + nick + "'" + ")";
        System.out.println(st);
        if(handler.execAction(st)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Saved");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Error with imputing data");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }
}
