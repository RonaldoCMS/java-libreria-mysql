package com.libro;

import java.util.Objects;

public class Libro {

    protected int id;
    protected String title;
    protected String author;
    protected float price;

    public Libro(int id, String title, String author, float price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Libro id(int id) {
        setId(id);
        return this;
    }

    public Libro title(String title) {
        setTitle(title);
        return this;
    }

    public Libro author(String author) {
        setAuthor(author);
        return this;
    }

    public Libro price(float price) {
        setPrice(price);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Libro)) {
            return false;
        }
        Libro libro = (Libro) o;
        return id == libro.id && Objects.equals(title, libro.title) && Objects.equals(author, libro.author) && price == libro.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, price);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", author='" + getAuthor() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }

    
}
