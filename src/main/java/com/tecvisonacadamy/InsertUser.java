package com.tecvisonacadamy;



import com.tecvisonacadamy.config.DataSourceConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class InsertUser {


    public InsertUser()
    {


    }

    public void insertUser(String firstName, String lastName, String email, LocalDate dob)
    {
        String insertQuery = "INSERT INTO users (firstname, lastname, email, dob) VALUES (?, ?, ?, ?)";

        try
        {
            //Establish connection
            Connection connection = DataSourceConfig.getDataSource().getConnection();

            //Create a prepared statement to execute the SQL query
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, dob.toString());

            //Execute the insert
            int rowInserted = preparedStatement.executeUpdate();

            //Output Result
            if(rowInserted > 0)
            {
                System.out.println("User inserted successfully");
            }

            preparedStatement.close();
            connection.close();


        }catch (SQLException ex)
        {

        }

    }
}
