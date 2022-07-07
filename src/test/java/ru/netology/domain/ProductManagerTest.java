package ru.netology.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product item1 = new Product(1, "nameqwerty1", 10);
    Product item2 = new Product(2, "name2", 20);
    Product item3 = new Product(3, "name3", 30);
    Product item4 = new Product(4, "nameqwerty4", 40);

    @BeforeEach
    public void setup() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
    }

    @Test
    public void shouldResultNoMatch() {

        boolean expected = false;
        boolean actual = manager.matches(item1, "qwerty10");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDoIfOneMatch() {

        boolean expected = true;
        boolean actual = manager.matches(item1, "qwerty");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchByIfNoMatch() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("qwerty10");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByIfOneMatch() {

        Product[] expected = {item1};
        Product[] actual = manager.searchBy("qwerty1");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByIfTwoMatches() {

        repo.add(item4);

        Product[] expected = {item1, item4};
        Product[] actual = manager.searchBy("qwerty");

        assertArrayEquals(expected, actual);
    }
}
