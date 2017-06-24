package de.marcelhuber.referenzprojektjavase7.db.test;

import de.marcelhuber.referenzprojektjavase7.db.MySQLConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel Huber
 */
public class MySQLConnectorTester {

    private String dummytable;

    {
        dummytable = "DUMMYTABLE";
    }
    Connection firstConnection;
    Connection secondConnection;

    public static void main(String[] args) {
        MySQLConnectorTester dummy = new MySQLConnectorTester();
        dummy.go();
        dummy.createTable();
        dummy.add("Huber");
        dummy.add("Herrig");
        dummy.add("Roth");
//        dummy.deleteTable();
    }

    private void go() {
        // kurzer Test, ob MySQLConnector ein Singleton ist
        MySQLConnector mysqlconnector = MySQLConnector.INSTANCE;
        MySQLConnector my2ndsqlconnector = mysqlconnector.INSTANCE;
        System.out.println("Haben wir etwa ein und das selber Connection-"
                + "Objekt, nur zwei Referenzen dahin? "
                + (mysqlconnector == my2ndsqlconnector));
        firstConnection = mysqlconnector.getConnection();
        secondConnection = mysqlconnector.getAnotherConnection();
        System.out.println(firstConnection == MySQLConnector.INSTANCE.getConnection());
        System.out.println(firstConnection == secondConnection);
        int counter = 0;
        try {
            ++counter;
//            firstConnection.close();
            ++counter;
            secondConnection.close();
        } catch (SQLException ex) {
            System.out.println("Problem beim Schließen der " + counter + "en "
                    + "Connection (Verbindung)!");
        }
        String tabelle = "mensch";
        String sql = "SELECT * FROM " + tabelle;
        String sqlAddMensch = "";
        try {
            ResultSet resultSet
                    = MySQLConnector.INSTANCE.getStatement().executeQuery(sql);
        } catch (SQLException sqlex) {
            System.out.println(sqlex);
            sqlex.printStackTrace();
        }
    }

    private void createTable() {
        try {
            MySQLConnector.INSTANCE.createTable(dummytable, "(\n"
                    + "  `id` int unsigned NOT NULL AUTO_INCREMENT,\n"
                    + "  `geburtsname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,\n"
                    + "  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n"
                    + "  `updated_at` timestamp NULL DEFAULT NULL,\n"
                    + "  PRIMARY KEY (`id`)\n"
                    + ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;");
        } catch (SQLException sqlex) {
            System.out.println(sqlex);
            sqlex.printStackTrace();
            return;
        }
    }

    private void add(String geburtsname) {
        String sql = "INSERT INTO `" + dummytable + "` (`geburtsname`) "
                + "VALUES ('" + geburtsname + "')";
        try {
            Statement stmt = firstConnection.createStatement();
            int number = stmt.executeUpdate(sql);
            System.out.println("\n" + number + " Datensätze hinzugefügt");
        } catch (SQLException ex) {
            System.out.println(ex);
            System.exit(0);
        }
    }

    private void deleteTable() {
        MySQLConnector.INSTANCE.deleteTable(dummytable);
    }
}
