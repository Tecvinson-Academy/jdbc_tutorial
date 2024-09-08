package com.tecvisonacadamy;

import com.tecvisonacadamy.model.User;

import java.sql.Date;
import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        //InsertUser insertUser = new InsertUser();

        //insertUser.insertUser("Richard","Moses","richard.m@gmail.com", LocalDate.of(2007, 12, 15));

        //RetrieveUser retrieveUser = new RetrieveUser();
        //retrieveUser.fetchAllUser();

       //UpdateUser updateUser = new UpdateUser();
       //updateUser.updateUserRecord(2, "Victor", "Solo", "laura.david@gmail.com", "1997-01-01");

       //ResultSetNavigation resultSetNavigation = new ResultSetNavigation();
       //resultSetNavigation.fetchAllUser();

        //MetaDataExample metaDataExample = new MetaDataExample();
        //metaDataExample.fetchAllUser();

        /*
        StoreProcedureExample storeProcedureExample = new StoreProcedureExample();

        User user = storeProcedureExample.getUserDetails(52);

        if(user.getFirstName() != null)
        {
            System.out.println("First Name: "+user.getFirstName());
            System.out.println("Last Name: "+user.getLastName());
            System.out.println("Email: "+user.getEmail());
            System.out.println("DOB: "+user.getDob());

        }else
        {
            System.out.println("User Not Found");
        }*/

        InsertOrUpdateUser insertOrUpdateUser = new InsertOrUpdateUser();

        insertOrUpdateUser.insertOrUpdate(4, "Ese","Kelvin", "esek@yahoo.com", Date.valueOf("1990-03-26"));


        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

    }
}