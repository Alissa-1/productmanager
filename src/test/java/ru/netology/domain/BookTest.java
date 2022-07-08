package ru.netology.domain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {
    Book book = new Book(1, "name1", 60, "Author1");

    @Test
    public void shouldResultMatchIfEmptySearch() {

        boolean expected = true;
        boolean actual = book.matches(book, "");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldResultPartMatchInName() {

        boolean expected = false;
        boolean actual = book.matches(book, "name2");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldResultMatchIfAbsolutelyDifferentInName() {

        boolean expected = false;
        boolean actual = book.matches(book, "pvc");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDoIfMatchInOneLetterInName() {

        boolean expected = true;
        boolean actual = book.matches(book, "m");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDoIfMatchInTwoLettersInName() {

        boolean expected = true;
        boolean actual = book.matches(book, "me");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDoIfFullMatchInName() {

        boolean expected = true;
        boolean actual = book.matches(book, "name1");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDoIfMatchThereIsUppercaseInName() {

        boolean expected = false;
        boolean actual = book.matches(book, "Name1");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldResultPartMatchInAuthor() {

        boolean expected = false;
        boolean actual = book.matches(book, "Author2");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldResultMatchIfAbsolutelyDifferentInAuthor() {

        boolean expected = false;
        boolean actual = book.matches(book, "pvc");

        assertEquals(expected, actual);
    }


    @Test
    public void shouldDoIfMatchInOneLetterInAuthor() {

        boolean expected = true;
        boolean actual = book.matches(book, "t");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDoIfMatchInTwoLettersInAuthor() {

        boolean expected = true;
        boolean actual = book.matches(book, "th");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDoIfFullMatchInAuthor() {

        boolean expected = true;
        boolean actual = book.matches(book, "Author1");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDoIfMatchNoUppercaseInAuthor() {

        boolean expected = false;
        boolean actual = book.matches(book, "author1");

        assertEquals(expected, actual);
    }
}
