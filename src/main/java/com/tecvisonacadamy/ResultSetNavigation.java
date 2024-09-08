package com.tecvisonacadamy;

import com.tecvisonacadamy.config.DataSourceConfig;

import java.sql.*;

public class ResultSetNavigation {


    public ResultSetNavigation()
    {

    }

    public void fetchAllUser()
    {
        try
        {
            String sqlQuery =  "SELECT * FROM users";


            //Establish connection
            Connection connection = DataSourceConfig.getDataSource().getConnection();

            //Create a prepared statement to execute the SQL query
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //Process the result set
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
             if(resultSet.first())
             {
                 System.out.println(resultSet.getInt("id")+ ", "+ resultSet.getString("firstname")+ ", "+ resultSet.getString("lastname")  +", "+ resultSet.getString("email") +" ,"+resultSet.getString("dob"));
             }else
             {
                 System.out.println("No result found");
             }


            resultSet.close();
            statement.close();
            connection.close();

        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}