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
import com.administrator.User;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.libro.Libro;

public class App 
{
    public static void main( String[] args ) throws IOException
    {

        Gson gson = new Gson();
        User user = gson.fromJson(Files.newBufferedReader(Paths.get("config.json")), User.class);
        LibroDAO connessione = new LibroDAO(user.getdatabase(), user.getUsername(), user.getPassword());
        try {
            //connessione.insertLibro(new Libro(10, "Fabio", "Ronaldo", 20));
            //connessione.updateLibro(new Libro(13, "Ronaldinho", "Ronaldo", 20));
            //connessione.deleteLibro(new Libro(13, "Ronaldinho", "Ronaldo", 20));
            System.out.println(connessione.listLibro().toString());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
