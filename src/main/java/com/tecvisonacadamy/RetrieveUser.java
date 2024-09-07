package com.tecvisonacadamy;

import java.sql.*;

public class RetrieveUser {

    private String username;
    private String password;
    private String jdbcUrl;

    public RetrieveUser(String jdbcUrl, String username, String password)
    {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }

    public void fetchAllUser()
    {
        try
        {
            String sqlQuery =  "SELECT * FROM users";


            //Establish connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            //Create a prepared statement to execute the SQL query
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            //Process the result set
            ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM users");

            while(resultSet.next())
            {
                System.out.println(resultSet.getInt("id")+ ", "+ resultSet.getString("firstname")+ ", "+ resultSet.getString("lastname")  +", "+ resultSet.getString("email") +" ,"+resultSet.getString("dob"));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        }catch (SQLException ex)
        {
          ex.printStackTrace();
        }
    }
}
