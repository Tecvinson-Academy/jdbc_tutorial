package com.tecvisonacadamy;

import com.tecvisonacadamy.config.DataSourceConfig;

import java.sql.*;

public class RetrieveUser {


    public RetrieveUser()
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
