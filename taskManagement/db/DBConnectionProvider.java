package taskManagement.db;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionProvider {
    private static DBConnectionProvider instance = new DBConnectionProvider();
    private Connection connection;

    private String DRIVER_NAME;
    private String DB_URL;
    private String DB_USERNAME;
    private String DB_PASSWORD;

    private DBConnectionProvider(){
        try {
            loadProperties();
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    private void loadProperties() {
        Properties properties=new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\Admin\\IdeaProjects\\FullStack20\\Task\\src\\main\\resources\\DBConfig.Properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        DRIVER_NAME=properties.getProperty("db.driver");
        DB_URL=properties.getProperty("db.url");
        DB_USERNAME=properties.getProperty("db.username");
        DB_PASSWORD=properties.getProperty("db.password");
    }

    public static DBConnectionProvider getInstance(){
        return instance;
    }

    public Connection getConnection()  {
        try {
            if (connection == null || connection.isClosed()) {
                connection= DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return connection;
    }
}