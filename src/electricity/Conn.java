package electricity;

import java.sql.*;


public class Conn {

    Connection c;
    Statement s;
    Conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///ebs", "root", "ruru@0715");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
