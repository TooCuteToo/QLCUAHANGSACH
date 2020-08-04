/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Provider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class SQLProvider {

    public Connection connection;
    public Statement statement;
    public PreparedStatement preState;

    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        String connectUrl = "jdbc:sqlserver://localhost;databaseName=QL_CUAHANGSACH;integratedSecurity = true";

        connection = DriverManager.getConnection(connectUrl);
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        return rs;
    }

    public void backUp() throws ClassNotFoundException, SQLException {
        connect();

        statement = connection.createStatement();
        statement.execute("Alter database QL_CUAHANGSACH\n" + "Set Recovery Full");

        statement.execute("backup database QL_CUAHANGSACH to disk = 'E:\\SQL\\hqtcsdl\\JAVA\\QL_CUAHANGSACH_FULL.bak'");
        statement.execute("backup database QL_CUAHANGSACH to disk = 'E:\\SQL\\hqtcsdl\\JAVA\\QL_CUAHANGSACH_DIFF.bak' with Differential");

        statement.execute("backup log QL_CUAHANGSACH to disk = 'E:\\SQL\\hqtcsdl\\JAVA\\QL_CUAHANGSACH_TRAN.trn'");
        statement.execute("backup log QL_CUAHANGSACH to disk = 'E:\\SQL\\hqtcsdl\\JAVA\\QL_CUAHANGSACH_LOG.log'");

        close();
    }

    public void restore() throws ClassNotFoundException, SQLException {

        String connectUrl2 = "jdbc:sqlserver://localhost;databaseName=master;integratedSecurity = true";
        try (Connection connection2 = DriverManager.getConnection(connectUrl2)) {

            Statement statement2 = connection2.createStatement();
            statement2.execute("ALTER DATABASE QL_CUAHANGSACH SET SINGLE_USER with rollback immediate");

            statement2.execute("backup log QL_CUAHANGSACH to disk = 'E:\\SQL\\hqtcsdl\\JAVA\\QL_CUAHANGSACH_LOG.log' WITH norecovery, CONTINUE_AFTER_ERROR");
            statement2.execute("restore database QL_CUAHANGSACH from disk = 'E:\\SQL\\hqtcsdl\\JAVA\\QL_CUAHANGSACH_FULL.bak' with norecovery");

            statement2.execute("restore database QL_CUAHANGSACH from disk = 'E:\\SQL\\hqtcsdl\\JAVA\\QL_CUAHANGSACH_DIFF.bak' with norecovery");
            statement2.execute("restore log QL_CUAHANGSACH from disk = 'E:\\SQL\\hqtcsdl\\JAVA\\QL_CUAHANGSACH_TRAN.trn' with norecovery");

            statement2.execute("restore log QL_CUAHANGSACH from disk = 'E:\\SQL\\hqtcsdl\\JAVA\\QL_CUAHANGSACH_LOG.log' with recovery");
            statement2.execute("ALTER DATABASE QL_CUAHANGSACH SET MULTI_USER with rollback immediate");
        }
    }

    public void close() throws SQLException {
        connection.close();
    }
}
