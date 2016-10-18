package geekbrains.java2.chat.server;

import java.sql.*;

class SQLHandler {
    private static Connection conn;
    private static Statement stmt;

    static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:users.db");
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static String getNickByLoginPass(String login, String pass) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT nick FROM test WHERE login = '" + login + "' AND pass = '" + pass + "'");
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    static boolean changeNick(String newNick, String nick) {
        try {
            if (stmt.executeQuery("SELECT id FROM test WHERE nick = '" + newNick + "'").next()) return false;
//            ResultSet rs = stmt.executeQuery("SELECT id FROM test WHERE nick = '" + nick + "'");
//            rs.next();
//            int id = rs.getInt(1);
            stmt.executeUpdate("UPDATE test SET nick = '" + newNick + "' WHERE nick = '" + nick + "'");
            return true; //если не получилось сменить ник из-за exception, то ник не меняется
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
