package database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class to connect to Database
 */

//  TO USE ON HELIOS

public class DBConnector {

    public static final Logger logger = LoggerFactory.getLogger("database");

    public Connection connect() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            logger.warn("DB driver not found!");
            return null;
        }
        String login = System.getenv("DB_LOGIN");
        String password = System.getenv("DB_PASSWORD");
        String host = System.getenv("DB_HOST");
        if (login == null || password == null) {
            logger.warn("Env variables DB_LOGIN or DB_PASSWORD are not matched!");
            return null;
        }
        if (host == null) {
            host = "jdbc:postgresql://pg:5432/studs";
        }
        return DriverManager.getConnection(host, login, password);
    }
}

//TO USE ON IDEA
//
//import com.jcraft.jsch.JSch;
//import com.jcraft.jsch.Session;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Properties;
//
//public class DBConnector {
//    private String DB_BASE;
//    private String DB_NAME;
//    private int DB_PORT;
//    private String DB_HOST;
//
//    private String SV_LOGIN;
//    private String SV_PASS;
//    private String SV_ADDR;
//
//    private int SV_PORT;
//
//    private int SSH_PORT;
//    private int FORWARDING_PORT;
//
//
//    public DBConnector() {
//        try {
//            this.DB_PORT = Integer.parseInt(System.getenv("DB_PORT"));//5432
//            this.DB_HOST = System.getenv("DB_HOST");// pg
//            this.DB_BASE = System.getenv("DB_BASE");// jdbc:postgresql://
//            this.DB_NAME= System.getenv("DB_NAME");// studs
//
//            this.SV_LOGIN = System.getenv("SV_LOGIN");// helios login
//            this.SV_PASS = System.getenv("SV_PASS"); // pass helios
//            this.SV_PORT = Integer.parseInt(System.getenv("SV_PORT")); //server port
//            this.SV_ADDR = System.getenv("SV_ADDR"); //helios.cs.ifmo.ru
//
//            this.SSH_PORT = Integer.parseInt(System.getenv("SSH_PORT")); // 2222
//            this.FORWARDING_PORT = Integer.parseInt(System.getenv("FORWARDING_PORT")); //9191
//
//            Properties config = new java.util.Properties();
//            config.put("StrictHostKeyChecking", "no");
//            JSch jsch = new JSch();
//            Session session = jsch.getSession(SV_LOGIN, SV_ADDR, SSH_PORT);
//            session.setPassword(SV_PASS);
//            session.setConfig(config);
//            session.connect();
//            session.setPortForwardingL(FORWARDING_PORT, DB_HOST, DB_PORT);
//        } catch (Exception e) {
//            System.err.println("Wrong format of env, please follow this format:\n" +
//                    "For ssh tunnel:\n" +
//                    "ssh -p SSH_PORT SV_LOGIN@SV_ADDR\n" +
//                    "Server login: SV_LOGIN\nServer password: SV_PASS\n" +
//                    "For database connection:\n" +
//                    "DB_BASE + DB_HOST + \":\" + FORWARDING_PORT + \"/\" + DB_NAME\n" +
//                    "FORWARDING_PORT - FORWARDING PORT"
//            );
//        }
//    }
//
//    public Connection connect() {
//        try {
//            Class.forName("org.postgresql.Driver");
//            return DriverManager.getConnection(DB_BASE + "localhost:" + FORWARDING_PORT + "/" + DB_NAME, SV_LOGIN, SV_PASS);
//        } catch (ClassNotFoundException e) {
//            System.err.println("PostgreSQL Driver not found");
//        } catch (SQLException e) {
//            System.err.println("Connection to database failed");
//        }
//        return null;
//    }
//}