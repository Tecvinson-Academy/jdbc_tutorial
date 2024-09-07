package com.tecvisonacadamy;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/jdbc_test";
        String username = "root";
        String password = "";

        //InsertUser insertUser = new InsertUser(jdbcUrl, username, password);

        //insertUser.insertUser("Richard","Moses","richard.m@gmail.com", LocalDate.of(2007, 12, 15));

        //RetrieveUser retrieveUser = new RetrieveUser(jdbcUrl, username, password);
        //retrieveUser.fetchAllUser();

       UpdateUser updateUser = new UpdateUser(jdbcUrl, username, password);
       updateUser.updateUserRecord(2, "Victor", "Solo", "laura.david@gmail.com", "1997-01-01");



        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

    }
}