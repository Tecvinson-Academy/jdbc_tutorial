package com.tecvisonacadamy;

import com.tecvisonacadamy.config.DataSourceConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUser {



    public UpdateUser()
    {
    }

    public void updateUserRecord(int userId, String firstName, String lastName, String email, String dob)
    {
        String updateQuery = "UPDATE users SET firstname = ?, lastname = ?, email = ?, dob = ? WHERE id = ?";

        try{

            //Establish connection
            Connection connection = DataSourceConfig.getDataSource().getConnection();

            //Create a prepared statement to execute the SQL query
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, dob);
            preparedStatement.setInt(5, userId);

            int rowsUpdated =  preparedStatement.executeUpdate();
            if(rowsUpdated > 0)
            {
                System.out.println("User updated successfully");
            }else {
                System.out.println("No user found with the given ID");
            }

        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
