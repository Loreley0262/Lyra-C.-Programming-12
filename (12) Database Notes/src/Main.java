import Database.DatabaseHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    static DatabaseHandler handler;
    public static void add(String name, String id, String email, String nick){

        boolean flag = name.isEmpty()||id.isEmpty()||email.isEmpty()||nick.isEmpty();
        if (flag){
            return;
        }
        String st = "INSERT INTO MEMBER VALUES (" +
                "'" + id + "'," +
                "'" + name + "',"+
                "'" + email + "',"+
                "'" + nick +"')";
        try {
            if (handler.execAction(st)){
                System.out.println("info entered");
            }
            else{
                System.out.println("info not entered");
            }
    }
        catch(Exception e) {
            System.out.println("error");
        }

    }

    public static void printMembers() throws SQLException{
        ArrayList<Member> members = new ArrayList<>();
        String qu = "SELECT * FROM MEMBER"; //change select to delete to delete member
        ResultSet rs = handler.execQuery(qu);

        while (rs.next()){
            String name = rs.getString("name");
            String id = rs.getString("id"); //single quotes for sql? idk what that means
            String nickname = rs.getString("nickname");
            String email = rs.getString("email");
            members.add(new Member(id, name, email, nickname));
        }

        Iterator<Member> iterator = members.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    public static void main(String[] args) throws SQLException {
        handler = new DatabaseHandler();
        Scanner scan = new Scanner(System.in);
        System.out.println("name?");
        String name = scan.next();
        System.out.println("id");
        String id = scan.next();
        System.out.println("nickname");
        String nickname = scan.next();
        System.out.println("email");
        String email = scan.next();
        add(name, id, email, nickname);
        printMembers();
    }
}
