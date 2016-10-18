package geekbrains.java2.chat.server;

import java.sql.*;

public class SQLHandler {
    private static Connection conn;
    private static Statement stmt;

    static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:users.db");
            stmt = conn.createStatement();
        } catch (Exception e) {
            System.out.println("Невозможно подключиться к БД");
        }
    }

    static String getNickByLoginPass(String login, String pass) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT nick FROM test WHERE login = '" + login + "' AND pass = '" + pass + "'");
            if (rs.next())
                return rs.getString(1);
            else
                return null;
        } catch (SQLException e) {
            System.out.println("Проблема при проверки логина/пароля > " + login + " / " + pass);
        }
        return null;
    }

    static boolean tryToChangeNick(String newNick, String nick) {
        try {
//            if (stmt.executeQuery("SELECT id FROM test WHERE nick = '" + newNick + "'").next()) return false;
//            ResultSet rs = stmt.executeQuery("SELECT id FROM test WHERE nick = '" + nick + "'");
//            rs.next();
//            int id = rs.getInt(1);
            int w = stmt.executeUpdate("UPDATE test SET nick = '" + newNick + "' WHERE nick = '" + nick + "';");
            //результат = количество обновлений базы, если 0, значит обновление не произошло
            return w == 1; //если не получилось сменить ник из-за exception, то ник не меняется
        } catch (SQLException e) {
            System.out.println("Проблемы с запросом");
        }
        return false;
    }

    public static void disconnect() {
        try {
            conn.close();
            System.out.println("Соединение с БД закрыто");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
