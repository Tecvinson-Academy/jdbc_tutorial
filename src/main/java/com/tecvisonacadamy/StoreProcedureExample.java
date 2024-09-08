package com.tecvisonacadamy;

import com.tecvisonacadamy.config.DataSourceConfig;
import com.tecvisonacadamy.model.User;

import java.sql.*;

public class StoreProcedureExample {

    public StoreProcedureExample()
    {

    }

    public User getUserDetails(int userId)
    {
     User user = null;

     try
     {
         //Establish connection
         Connection connection = DataSourceConfig.getDataSource().getConnection();

         CallableStatement callableStatement = connection.prepareCall("CALL getUserDetails(?, ?, ?, ?, ?)");

         callableStatement.setInt(1, userId);

         callableStatement.registerOutParameter(2, Types.VARCHAR);
         callableStatement.registerOutParameter(3, Types.VARCHAR);
         callableStatement.registerOutParameter(4, Types.VARCHAR);
         callableStatement.registerOutParameter(5, Types.DATE);

         callableStatement.execute();

         String firstName = callableStatement.getString(2);
         String lastName = callableStatement.getString(3);
         String email = callableStatement.getString(4);
         Date dob = callableStatement.getDate(5);

         user = new User(firstName, lastName, email, dob);


     }catch(SQLException ex)
     {
         ex.printStackTrace();
     }



     return user;
    }
}
