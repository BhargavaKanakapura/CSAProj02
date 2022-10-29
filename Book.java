package Unit2Project;
/*
 * AP CS A
 * PROJ 02: OOP ~ L.M.S.
 * SFHS ~ Mrs. Vollucci
 *
 * Replace with Franco Lashgari
 * Replace with Bhargava Kanakapura
 * Replace with Period 5
 */

import java.util.Objects;

class Book {

    // instance variables (given) (Phase A)
    protected String title;
    protected String author;
    protected String genre;
    protected String ISBN;
    protected double fee = 0.50;


    // Fill in this constructor (Phase A)
    public Book(String title, String author, String genre, String ISBN)
    {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.ISBN = ISBN;
    }

    // No setters (the attributes should stay the same)

    // Fill in the getters for all attributes (Phase A)

    public String getTitle()
    {
        return this.title; // replace this line
    }

    public String getAuthor()
    {
        return this.author; // replace this line
    }

    public String getGenre()
    {
        return this.genre; // replace this line
    }

    public String getISBN()
    {
        return this.ISBN; // replace this line
    }


    /* Fill in this method (Phase A)
     * Override the built-in equals() method for specific
     * Book object functionality.
     *
     * Two books are equal if they have the same ISBN #.
     */
    public boolean equals(Book book)
    {
        return Objects.equals(this.getISBN(), book.getISBN()); // replace this line
    }

    /* Fill in this method (Phase G)
     * Return the book fee.
     */
    public double getFee()
    {
        return fee; // replace this line
    }

    // Fill in the toString() method (Phase A)

    public String toString()
    {
        return ("{Title: " + getTitle() + "}/n" + "Author: " + getAuthor() + "/n" + "Genre: " + getGenre() + "/n" + "ISBN #: " + getISBN() );
    }
}
