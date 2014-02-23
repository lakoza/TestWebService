package com.anneke;

import java.sql.*;

public class TestSQLLiteConnection {

    public StringBuffer getResulSetData() {
        StringBuffer output = new StringBuffer();

        Connection connection = null;
        try
        {
            // load the sqlite-JDBC driver using the current class loader
            Class.forName("org.sqlite.JDBC");

            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:G:\\sqllite\\1.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("select * from t");
            int n = rs.getMetaData().getColumnCount();
            while(rs.next())
            {
                output.append("<row>");
                for (int i=1; i<=n; i++){
                    output.append(String.format(TestServlet.tableColTemplate, rs.getObject(i)));
                }
                output.append("</row>");
                output.append("\n");
            }
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println("hui");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e);
            }
        }

        return output;
    }

    public String getXML(){
        TestSQLLiteConnection dbData = new TestSQLLiteConnection();
        StringBuffer data = new StringBuffer();
        data.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<rows>");
        data.append(dbData.getResulSetData());
        data.append("</rows>");

        return data.toString();
    }

    public static void main(String[] args) throws ClassNotFoundException
    {
        TestSQLLiteConnection dbData = new TestSQLLiteConnection();
        StringBuffer data = new StringBuffer();
        data.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<rows>");
        data.append(dbData.getResulSetData());
        data.append("</rows>");

        System.out.println(data);

    }
}
