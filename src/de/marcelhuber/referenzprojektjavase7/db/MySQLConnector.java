package de.marcelhuber.referenzprojektjavase7.db;
// DER SQL-Connector kann momentan auch Tables erstellen und löschen
// Rein zu Testzwecken

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Marcel Huber
 */
// MySQLConnector als Singleton!
public enum MySQLConnector {
    INSTANCE;

    private Connection connection;
    // rein zu Testzwecken die Möglichkeit einer weiteren Verbindung
    private Connection anotherConnection;
    private Statement statement;
    // 
    // verbindungs-parameter
    private String host;
    private String user;
    private String pass;
    private String db;

    private MySQLConnector() {
        initParameter();
    }

    private void initParameter() {
        Properties props = new Properties();
        try (FileReader fr = new FileReader("dbconnectionReferenzprojekt.properties")) {

            props.load(fr);
            // Verbindungsparameter aus properties-file
            host = props.getProperty("jdbc.host", "localhost" + ":3306");
            user = props.getProperty("jdbc.user");
            pass = props.getProperty("jdbc.pass");
            db = props.getProperty("jdbc.db");

        } catch (IOException ex) {
            System.out.println(ex);
        }

        String url = "jdbc:mysql://" + host + "/" + db;
        try {
            // WICHTIG: Das Connection-Objekt erhalten wir über "den" DriverManager            
            connection = DriverManager.getConnection(url, user, pass);
            // mit dem Connection-Objekt können wir (versuchen,)  ein Statement (zu) erzeugen
            statement = connection.createStatement();
            System.out.println("MySQL-Verbindung erfolgreich hergestellt!");
        } catch (SQLException sqlex) {
            System.out.println(sqlex);
            sqlex.printStackTrace();
        }
    }

    public Connection getAnotherConnection() {
        try {
            String url = "jdbc:mysql://" + host + "/" + db;
            anotherConnection = DriverManager.getConnection(url, user, pass);
            System.out.println("Eine weitere Verbindung wurde erfolgreich "
                    + "hergestellt!");
        } catch (SQLException sqlex) {
            System.out.println(sqlex);
            sqlex.printStackTrace();
        }
        return anotherConnection;
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
        }
    }

    public void createTable(String table, String createBefehl) throws SQLException {
        try {
            statement.execute("CREATE TABLE `" + table + "`"
                    + createBefehl);
        } catch (SQLException sqlex) {
//            System.out.println(sqlex);
//            sqlex.printStackTrace();
            throw (sqlex);
        }
    }

    public void dropTable(String table) {
        try {
            statement.execute("DROP TABLE `" + table + "`");
        } catch (SQLException sqlex) {
            System.out.println(sqlex);
            sqlex.printStackTrace();
        }
    }

    public void deleteTable(String table) {
        dropTable(table);
    }
}