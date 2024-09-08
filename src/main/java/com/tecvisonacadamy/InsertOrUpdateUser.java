package com.tecvisonacadamy;

import com.tecvisonacadamy.config.DataSourceConfig;

import java.sql.*;

public class InsertOrUpdateUser {

    public InsertOrUpdateUser()
    {

    }

    public void insertOrUpdate(Integer userId, String firstName, String lastName, String email, Date dob)
    {
        try
        {
            Connection connection = DataSourceConfig.getDataSource().getConnection();

            CallableStatement callableStatement = connection.prepareCall("CALL insertOrUpdateUser(?, ?, ?, ?, ?)");

            if(userId == null)
            {
               callableStatement.setNull(1, Types.INTEGER);
            }else
            {
               callableStatement.setInt(1, userId);
            }

            callableStatement.setString(2, firstName);
            callableStatement.setString(3, lastName);
            callableStatement.setString(4, email);
            callableStatement.setDate(5, dob);

            callableStatement.execute();

            System.out.println("User inserted/updated successfully");


        }catch (SQLException ex)
        {

        }


    }
}
