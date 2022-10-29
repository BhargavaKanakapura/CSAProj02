package Unit2Project;
/*
 * AP CS A
 * PROJ 02: OOP ~ L.M.S.
 * SFHS ~ Mrs. Vollucci
 *
 * Replace with Partner A's Full Name
 * Replace with Partner B's Full Name
 * Replace with Period #
 */

import java.util.ArrayList;

class Catalogue {

    // Instance variables (given)
    private ArrayList<Book> books;
    private ArrayList<Integer> bookCounts;

    // Write the constructor - no inputs needed (Phase B)
    public Catalogue(){
        books = new ArrayList<>();
        bookCounts = new ArrayList<>();
    }
    // Write getters for both ArrayLists (Phase B)

    // Create getBooks() here
    public ArrayList<Book> getBooks(){
        return books;
    }
    // Create getBookCounts() here
    public ArrayList<Integer> getBookCounts(){
        return bookCounts;
    }
    /* Fill in this method (Phase B)
     * Adjust the quantity available of a Book by a specified amount.
     * Return true if the action was successful and false if not.
     */

    public boolean adjustQuantity(Book book, int amount)
    {
        // If the book already exists, increase the quantity
        // Your code here
        for (int i = 0; i < this.getBooks().size(); i++) {
            if (this.getBooks().get(i).equals(book)) {
                bookCounts.set(i, bookCounts.get(i) + amount);
                return true;
            }
        }

        return false;
    }

    /* Fill in this method (Phase B)
     * Add a Book to the list.
     */

    public void addBook(Book book)
    {
        for (int i = 0; i < this.getBooks().size(); i++) {
            if (this.getBooks().get(i).equals(book)) {
                adjustQuantity(book, 1);
                return;
            }
        }
        books.add(book);
        bookCounts.add(1);
    }

    /* Fill in this method (Phase B)
     * Find Books from the list based on the ff. categories:
     * (1) title, (2) author, (3) genre, (4) ISBN
     * in addition to the user's query.
     *
     * Edit this method (Phase H)
     * Handle case for Textbooks with multiple authors.
     */

    public ArrayList<Book> findBook(int category, String query)
    {
        ArrayList<Book> books = new ArrayList<Book>();

        if (category == 1){
            for (Book i : this.books){
                if (i.getTitle().equals(query)) {
                    books.add(i);
                }
            }
        } else if (category == 2){
            for(Book i : this.books){
                if (i instanceof Textbook) {
                    for (String a : ((Textbook) i).getAuthors()) {
                        if (a.equals(query)) {
                            books.add(i);
                        }
                    }
                } else if (i.getAuthor().equals(query))
                {
                    books.add(i);
                }
            }
        } else if (category == 3) {
            for (Book i : this.books){
                if (i.getGenre().equals(query)){
                    books.add(i);
                }
            }
        } else if (category == 4){
            for(Book i : this.books){
                if ((i.getISBN()).equals(query)) {
                    books.add(i);
                }
            }
        }
        return books;
    }

    /* Fill in this method (Phase F)
     * Pull out the available quantity of books via a specified book.
     * If the book is not found, return -1.
     */
    public int getBookCount(Book book)
    {
        for (int i = 0; i < this.books.size(); i++) {
            if (this.books.get(i).equals(book)) {
                return this.bookCounts.get(i);
            }
        }
        return -1;
    }

    /* Write this function (Phase I)
     * Return a list of all Books mentioning a specified word in the title.
     * You may assume that keyword is separated by a space from other words.
     */
    public ArrayList<Book> findKeywordBook(String keyword)
    {

        ArrayList<Book> matchingBooks = new ArrayList<>();

        for (Book b : books) {
            for (String w : b.getTitle().split(" ")) {
                if (w.equals(keyword)) {
                    matchingBooks.add(b);
                }
            }
        }

        return matchingBooks;

    }

    // Fill in the toString() method (Phase B)
    public String toString()
    {
        // Return catalogue with book quantity included for each entry
        // Your code here
        String str = "";
        for(int i = 0;i < books.size(); i++){
            str = str + i + ". " + this.getBooks().get(i)
                    + "\n" + bookCounts.get(i)
                    + "\n, \n";
        }
        return str; // replace this line
    }
}
