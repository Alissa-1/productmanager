package ru.netology.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product item1 = new Book(1, "nameqwerty1", 60, "author1");
    Product item2 = new Book(2, "name2", 70, "author2");
    Product item3 = new Smartphone(3, "name3", 80, "Manufacturer3");
    Product item4 = new Smartphone(4, "naMeqwerty4", 90, "Manufacturer4");

    @BeforeEach
    public void setup() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
    }

    // Task 2
    @Test
    public void shouldResultNoMatchInNameAndAuthor() {

        boolean expected = false;
        boolean actual = manager.matches(item1, "qwerty3");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldResultMatchInAuthor() {

        boolean expected = true;
        boolean actual = manager.matches(item1, "author1");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldResultNoMatchInNameAndManufacturer() {

        boolean expected = false;
        boolean actual = manager.matches(item1, "pvb");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldResultMatchInManufacturer() {

        boolean expected = true;
        boolean actual = manager.matches(item3, "Manufacturer3");

        assertEquals(expected, actual);
    }

    // Task 1
    @Test
    public void shouldResultNoMatchInName() {

        boolean expected = false;
        boolean actual = manager.matches(item1, "qwerty3");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDoIfOneMatchInName() {

        boolean expected = true;
        boolean actual = manager.matches(item1, "qwerty");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDoIfOneMatchAndUppercaseInName() {

        boolean expected = true;
        boolean actual = manager.matches(item4, "aM");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDoIfNotMatchLowAndUppercaseInName() {

        boolean expected = false;
        boolean actual = manager.matches(item1, "aM");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchByIfNoMatchInName() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("qwerty3");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByIfOneMatchInName() {

        Product[] expected = {item1};
        Product[] actual = manager.searchBy("qwerty1");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByIfTwoMatchesInName() {

        repo.add(item4);

        Product[] expected = {item1, item4};
        Product[] actual = manager.searchBy("qwerty");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByIfAllMatchesInName() {

        Product[] expected = {item1, item2, item3};
        Product[] actual = manager.searchBy("name");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnAllWhenSearchByEmpty() {

        Product[] expected = {item1, item2, item3};
        Product[] actual = manager.searchBy("");

        assertArrayEquals(expected, actual);
    }
}
