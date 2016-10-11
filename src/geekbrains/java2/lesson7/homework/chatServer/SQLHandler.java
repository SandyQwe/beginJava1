package geekbrains.java2.lesson7.homework.chatServer;

import java.sql.*;

public class SQLHandler {
    private static Connection conn;
    private static Statement stmt;

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:users.db");
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getNickByLoginPass(String login, String pass) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT nick FROM test WHERE login = '" + login + "' AND pass = '" + pass + "'");
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String changeNick(String newNick, String nick) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT id FROM test WHERE nick = '" + nick + "'");
            rs.next();
            int id = rs.getInt(1);
            stmt.execute("UPDATE test SET nick = '" + newNick + "' WHERE id = " + id + ";");
            return newNick; //если не получилось сменить ник из-за exception, то ник не меняется
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nick;
    }

    public static void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
