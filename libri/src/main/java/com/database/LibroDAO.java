package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.libro.Libro;

public class LibroDAO {

    private String jdbcURL; 
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public LibroDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    public void connect() throws SQLException {

        //Controllo se è stato già aperto la connessione
        if(jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Errore metodo connect()");
            }
            //Chiedo a Java di connettersi a questo database con questo utente.
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    public void insertLibro(Libro libro) {

    }

    public void updateLibro(Libro libro) {

    }

    public void deleteLibro(Libro libro) {

    }

    public Libro getLibro(int id) {
        return null;
    }

    public List<Libro> listLibro() throws SQLException {
        //Creo una lista di Libro
        List<Libro> listBook = new ArrayList<Libro>();
        String sql = "SELECT * FROM book";
        connect();

        //Preparo un statement per operare sulle querry
        Statement statement = jdbcConnection.createStatement();
        
        //Il risultato della querry lo salvo dentro l'oggetto ResultSet
        ResultSet resultSet = statement.executeQuery(sql);

        /***
         *  il metodo next itera per ogni record al termine dell'istruzione, una volta iterato tutti i record esce dal ciclo.
         */
        while(resultSet.next()) {
            /*
            *Poichè l'oggetto LIBRO ha gli stessi attributi della tabella Book, salviamo ogni attributo del record all'oggetto e infine
            *decidiamo di importarlo l'oggetto stesso dentro la lista.
            */
            int id = resultSet.getInt("book_id");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            float price = resultSet.getFloat("price");

            Libro libro = new Libro(id, title, author, price);
            listBook.add(libro);
        }
        //Chiudiamo gli oggetti utilizzati per questo metodo
        resultSet.close();
        statement.close();

        return listBook;
    }


    public String getJdbcURL() {
        return this.jdbcURL;
    }

    public void setJdbcURL(String jdbcURL) {
        this.jdbcURL = jdbcURL;
    }

    public String getJdbcUsername() {
        return this.jdbcUsername;
    }

    public void setJdbcUsername(String jdbcUsername) {
        this.jdbcUsername = jdbcUsername;
    }

    public String getJdbcPassword() {
        return this.jdbcPassword;
    }

    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }

    public Connection getJdbcConnection() {
        return this.jdbcConnection;
    }

    public void setJdbcConnection(Connection jdbcConnection) {
        this.jdbcConnection = jdbcConnection;
    }
    

    @Override
    public String toString() {
        return "{" +
            " jdbcURL='" + getJdbcURL() + "'" +
            ", jdbcUsername='" + getJdbcUsername() + "'" +
            ", jdbcPassword='" + getJdbcPassword() + "'" +
            ", jdbcConnection='" + getJdbcConnection() + "'" +
            "}";
    }    

}