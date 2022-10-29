package Unit2Project;/*
 * AP CS A
 * PROJ 02: OOP ~ L.M.S.
 * SFHS ~ Mrs. Vollucci
 *
 * Replace with Partner A's Full Name
 * Replace with Partner B's Full Name
 * Replace with Period #
 */

import java.util.*;
import java.lang.Math;


class Member {
    // instance variables (given)
    private final String firstName;
    private final String lastName;
    private final String email;
    private Library library;
    private boolean atLibrary;
    // ArrayLists (given) (Phase G)
    private ArrayList<Book> checkedOutBooks = new ArrayList<>();
    private ArrayList<LibraryDate> checkOutDates = new ArrayList<>();

    // Fill in this constructor (Phase C)
    public Member(String name, String email)
    {
        String[] nameArr = name.split(" ");
        this.firstName = nameArr[0];
        this.lastName = nameArr[1];
        this.email = email;
    }

    // getters (given)
    public String getName()
    {
        return lastName + ", "+ firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public String getLibrary()
    {
        if (library != null)
        {
            return library.getName();
        }
        return null;
    }

    // given
    public boolean memberAtLibrary()
    {
        return this.atLibrary;
    }

    /* Fill in this method (Phase D)
     * When Library adds this member, that Library becomes this member's
     * Library and returns true. However if members already belong to a
     * library, they cannot join a new library and should return false.
     */

    public boolean addMemberToLibrary(Library library)
    {
        if (this.library == null) {
            this.library = library;
            return true;
        }
        return false;
    }

    /* Fill in this method (Phase D)
     * If member is not currently at the library, then they can visit,
     * changing their state and increasing library visitor count by 1
     */
    public void goToLibrary()
    {
        if (!atLibrary) {
            atLibrary = true;
            this.library.increaseVisitorCount();
        }
    }

    /* Fill in this method (Phase D)
     * If member is currently at the library, then they can leave,
     * changing their state and decreasing library visitor count by 1
     */

    public void leaveLibrary()
    {
        if (atLibrary) {
            atLibrary = false;
            this.library.decreaseVisitorCount();
        }
    }


    /* Fill in this method (Phase F)
     * If user is at the library, add the book and the date to their
     * check-out dates list. If action is successful, return true.
     * Otherwise return false.
     */

    public boolean checkOutBook(Book myBook, int month, int day, int year)
    {
        if (this.atLibrary && this.library.getCatalogue().getBookCount(myBook) > 0) {
            LibraryDate ld = new LibraryDate(month, day, year);
            this.checkedOutBooks.add(myBook);
            this.checkOutDates.add(ld);
            this.library.getCatalogue().adjustQuantity(myBook, -1);
            return true;
        } else {
            return false;
        }
    }

    /* Fill in this method (Phase G)
     * If user is at the library and has the book to return, then
     * it removes the book and date from the user's lists.
     *
     * It returns the fee the user owes the library based on how late they
     * kept the book past the due date (7 days past the check out day).
     *
     * It should also update the fee for that user in the Library's
     * system by the specified amount. If action is unsuccessful, return -1.
     */
    public double returnBook(Book myBook, int month, int day, int year)
    {
        if (this.atLibrary) {
            for (int i = 0; i < this.checkedOutBooks.size(); i++) {
                if (this.checkedOutBooks.get(i).equals(myBook)) {
                    this.checkedOutBooks.remove(i);
                    LibraryDate dueDate = this.checkOutDates.remove(i);
                    this.library.getCatalogue().adjustQuantity(myBook, 1);
                    int daysOverdue = (int) (dueDate.daysPast(month, day, year));
                    if (daysOverdue < 7) {return 0;}
                    else {
                        double fee = (daysOverdue - 7) * myBook.getFee();
                        this.library.adjustFee(this.email, fee);
                        return fee;
                    }
                }
            }
        }
        return -1;
    }

    // given
    public ArrayList<Book> getCheckedOutBooks()
    {
        return this.checkedOutBooks;
    }

    // toString() method (given)
    public String toString()
    {
        if (library != null)
        {
            return getLibrary() + " Member[" + "Name: " + firstName + " " + lastName + ", " + "Email: " + email +"]";
        }
        return " Member[" + "Name: " + firstName + " " + lastName + ", " + "Email: " + email +"]";
    }
}
