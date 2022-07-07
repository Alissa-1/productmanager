package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();
    Product item1 = new Product(1, "nameqwerty1", 10);
    Product item2 = new Product(2, "name2", 20);
    Product item3 = new Product(3, "name3", 30);
    Product item4 = new Product(4, "nameqwerty4", 40);
    Product item5 = new Product(5, "name5", 50);

    @BeforeEach
    public void setup() {
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
    }

    @Test
    public void shouldFindAllIfEmpty() {
        repo.removeById(item1.getId());
        repo.removeById(item2.getId());
        repo.removeById(item3.getId());

        Product[] expected = {};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneProductInEmpty() {
        repo.removeById(item1.getId());
        repo.removeById(item2.getId());
        repo.removeById(item3.getId());

        repo.add(item4);

        Product[] expected = {item4};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneProductInNotEmpty() {
        repo.add(item4);

        Product[] expected = {item1, item2, item3, item4};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddTwoProducts() {
        repo.add(item4);
        repo.add(item5);

        Product[] expected = {item1, item2, item3, item4, item5};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdOneProduct() {
        repo.removeById(item2.getId());

        Product[] expected = {item1, item3};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdTwoProducts() {
        repo.removeById(item1.getId());
        repo.removeById(item2.getId());

        Product[] expected = {item3};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdAllProducts() {
        repo.removeById(item1.getId());
        repo.removeById(item2.getId());
        repo.removeById(item3.getId());

        Product[] expected = {};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }
}
