package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;

import com.database.LibroDAO;
import com.database.User;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

/**
 * Hello world!
 *
 */
public class App 
{
  

    public static void main( String[] args ) throws IOException
    {

        //String json = "{'database' : 'jdbc:mysql://localhost:3306/java-libreria-mysql','username' : 'root','password' : ''}";
        Gson gson = new Gson();
        User user = gson.fromJson(Files.newBufferedReader(Paths.get("config.json")), User.class);
        LibroDAO connessione = new LibroDAO(user.getdatabase(), user.getUsername(), user.getPassword());
        try {
            System.out.println(connessione.listLibro().toString());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
