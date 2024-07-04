package com.sistemi.informativi.connection;

import java.sql.*;

public class ConnectionManager implements DbParameters {


    private static Connection con;

    /**
     * @return una connessione che fa riferimento ad una singola istanza(pattern Singleton)
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (con == null) {

            Class.forName(dbDriver);

            con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        }
        return con;
    }

    //RESTITUISCE PREPAREDSTATEMENT

    public static PreparedStatement getPreparedStatement(String sql) throws SQLException, ClassNotFoundException {

        return getConnection().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

    }


    //RESTITUISCE STATEMENT
    public static ResultSet getResultset(String sql) throws SQLException, ClassNotFoundException {
        return getConnection().createStatement().executeQuery(sql);

    }


    //CHIUDE LA CONNESSIONE

    public static void closeConnection() throws SQLException, ClassNotFoundException {

        getConnection().close();
    }


}
