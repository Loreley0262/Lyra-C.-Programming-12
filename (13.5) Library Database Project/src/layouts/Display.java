package layouts;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import sample.DatabaseHandler;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

public class Display implements Initializable {
    public DatabaseHandler handler;
    public ListView listMembers = new ListView();
    public ListView listBooks = new ListView();
    public Button btnShow;


    public void printMembers(ActionEvent actionEvent) throws SQLException {
        ArrayList<model.Member> members = new ArrayList<>();
        String qu = "SELECT * FROM MEMBER"; //change select to delete to delete member
        ResultSet rs = handler.execQuery(qu);

        while (rs.next()) {
            String name = rs.getString("name");
            String id = rs.getString("id"); //single quotes for sql? idk what that means
            String nickname = rs.getString("nickname");
            String email = rs.getString("email");
            model.Member bob = new model.Member(id, name, nickname, email);
            members.add(bob);

            listMembers.getItems().add(bob.toString());
        }

        Iterator<model.Member> iterator = members.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        ArrayList<Book> book = new ArrayList<>();
        String qq = "SELECT * FROM BOOK"; //change select to delete to delete member
        ResultSet resultSet = handler.execQuery(qq);

        while (resultSet.next()) {
            String title = resultSet.getString("book");
            String id = resultSet.getString("id"); //single quotes for sql? idk what that means
            Book bobb = new Book(id, title);
            book.add(bobb);
            listBooks.getItems().add(bobb.toString());
        }

        Iterator<Book> iteratorb = book.iterator();
        while (iteratorb.hasNext()) {
            System.out.println(iteratorb.next());
        }

        btnShow.setVisible(false);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        handler = DatabaseHandler.getHandler();
    }
}


