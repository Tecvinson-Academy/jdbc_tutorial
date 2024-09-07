package com.tecvisonacadamy;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class InsertUser {

    private String username;
    private String password;
    private String jdbcUrl;

    public InsertUser(String jdbcUrl, String username, String password)
    {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;

    }

    public void insertUser(String firstName, String lastName, String email, LocalDate dob)
    {
        String insertQuery = "INSERT INTO users (firstname, lastname, email, dob) VALUES (?, ?, ?, ?)";

        try
        {
            //Establish connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

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
