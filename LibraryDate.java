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

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

// Read through given class code (Phase G)

class LibraryDate {

    private final LocalDate myDate;

    public LibraryDate(int month, int day, int year){
        this.myDate = LocalDate.of(year, month, day);
    }

    public long daysPast(int month, int day, int year){
        LocalDate newDate = LocalDate.of(year, month, day);
        return ChronoUnit.DAYS.between(this.myDate, newDate);
    }

    public static void main(String[] args) {
        LibraryDate a = new LibraryDate(10,12,2001);
        System.out.println(a.daysPast(10,17,2001));
    }
}
